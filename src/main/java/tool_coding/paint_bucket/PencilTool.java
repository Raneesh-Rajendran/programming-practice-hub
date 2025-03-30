package main.java.tool_coding.paint_bucket;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class PencilTool extends MouseAdapter {
  private Point initial;
  private Point end;

  @Override
  public void mousePressed(MouseEvent e) {
    initial = e.getPoint();
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    end = e.getPoint();

    // draw a line
    BufferedImage image = ImagePanelSingleton.INSTANCE.editableImage;
    Graphics2D g2d = (Graphics2D) image.getGraphics();
    g2d.setColor(Color.BLACK);
    g2d.drawLine(initial.x, initial.y, end.x, end.y);

    ImagePanelSingleton.INSTANCE.repaint();

    // re-assign the initial point
    initial = e.getPoint();
  }
}
