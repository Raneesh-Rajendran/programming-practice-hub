package main.java.tool_coding.paint_bucket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;

public class ImagePanelSingleton extends JPanel {
  public static final ImagePanelSingleton INSTANCE = new ImagePanelSingleton();
  public BufferedImage editableImage;

  private ImagePanelSingleton() {
    // initialize the BufferedImage and give it a white background
    editableImage = new BufferedImage(300, 300, BufferedImage.TYPE_4BYTE_ABGR);
    Graphics2D g2d = (Graphics2D) editableImage.getGraphics();
    g2d.setColor(Color.WHITE);
    g2d.fillRect(100, 100, 300, 300);

    // add some mouse motion controls to this JPanel - i.e. the mouse drawing and paint bucket tool
    MouseAdapter drawTool = new PencilTool();
    this.addMouseListener(drawTool);
    this.addMouseMotionListener(drawTool);

    MouseAdapter bucketTool = new BucketTool();
    this.addMouseListener(bucketTool);
    this.addMouseMotionListener(bucketTool);
  }

  @Override
  public Dimension getPreferredSize() {
    final int WIDTH = editableImage.getWidth();
    final int HEIGHT = editableImage.getHeight();
    return new Dimension(WIDTH + 100, HEIGHT + 100);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(editableImage, 0, 0, null);
  }
}
