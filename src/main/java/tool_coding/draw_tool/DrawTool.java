package main.java.tool_coding.draw_tool;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class DrawPanel extends JPanel implements MouseMotionListener, MouseListener {
    Point lastPoint=null;
    boolean isDragging=false;
    Polygon currentPoly=null;
    ArrayList polyList=new ArrayList(); // finished shapes
    ArrayList currPoints=new ArrayList(); // current drawing shape

    public DrawPanel() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    public void update(Graphics g) {
        Color c=g.getColor();
        // draw background
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        Graphics2D g2D=(Graphics2D)g;
        // draw finished shapes
        for (int i=0; i<polyList.size(); i++) {
            Polygon pol=(Polygon)polyList.get(i);
            g2D.setColor(Color.black);
            g2D.drawPolygon(pol);
            g2D.setColor(Color.blue);
            g2D.fill(pol);
        }
        // draw current shape (if any)
        g2D.setColor(Color.black);
        for (int i=0; i<currPoints.size(); i++) {
            if (i < currPoints.size()-1) {
                Point p0=(Point)currPoints.get(i);
                Point p1=(Point)currPoints.get(i+1);
                g2D.drawLine(p0.x,p0.y,p1.x,p1.y);
            }
        }
        g.setColor(c);
    }
    public void paint(Graphics g) {
        update(g);
    }
    public void mouseDragged(MouseEvent e) {
        if (!isDragging) {
            currentPoly=new Polygon();
            currentPoly.addPoint(lastPoint.x,lastPoint.y);
            currPoints.add(new Point(e.getX(),e.getY()));
        }
        isDragging=true;

        currentPoly.addPoint(e.getX(),e.getY());
        currPoints.add(new Point(e.getX(),e.getY()));

        repaint();
    }
    public void mouseMoved(MouseEvent e) {}

    // deletes shape(s) if rightclicked inside
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            for (int i=polyList.size()-1; i>=0; i--) {
                Polygon pol=(Polygon)polyList.get(i);
                if (pol.contains(e.getPoint())) {
                    polyList.remove(i);
                }
            }
        }
        repaint();
    }

    public void mousePressed(MouseEvent e) {
        lastPoint=e.getPoint();
    }
    public void mouseReleased(MouseEvent e) {
        if (isDragging) {
            polyList.add(currentPoly); // add new shape to list
            currPoints.clear(); // initialize current drawing shape
        }
        isDragging=false;
        repaint();
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }

}
public class DrawTool extends JFrame {
    public DrawTool() {
    }
    public static void main(String[] args)  {
        DrawTool dt = new DrawTool();
        dt.getContentPane().setLayout(new GridLayout());
        dt.getContentPane().add(new DrawPanel());
        dt.setBounds(100,100,400,300);
        dt.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        dt.setVisible(true);
    }
}