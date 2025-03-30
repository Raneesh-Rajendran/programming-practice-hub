package main.java.tool_coding.paint_bucket;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class BucketTool extends MouseAdapter {

  @Override
  public void mousePressed(MouseEvent e) {
    // do nothing if the Ctrl key is not being held down
    if (!e.isControlDown()) return;

    // How should I implement the rest of this method?
    BufferedImage image = ImagePanelSingleton.INSTANCE.editableImage;
    Graphics2D g2d = (Graphics2D) image.getGraphics();

    ImagePanelSingleton.INSTANCE.repaint();
  }
}
