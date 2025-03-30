package main.java.tool_coding.paint_bucket;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintBucket extends JPanel
    implements MouseListener, MouseMotionListener, ActionListener {

  /** Default serial id. */
  private static final long serialVersionUID = 1L;

  /** Size of the main panel. */
  private static final Dimension PANEL_DIM = new Dimension(640, 480);

  /** Location of beginning of mouse drag. */
  private int mouseDownX, mouseDownY;

  /** Location of mouse during drag. */
  private int currentMouseX, currentMouseY;

  /** Whether mouse button is currently pressed. */
  private boolean mouseDown;

  /** Button that displays color dialog. */
  private final JButton colorChooserButton;

  /** Combo box to choose tool. */
  private final JComboBox toolComboBox;

  /** Current tool color. */
  private Color currentColor;

  /** Image to Draw to. */
  private final BufferedImage image;

  /** Initializes window. */
  public PaintBucket() {
    JFrame frame = new JFrame("Paint Bucket");
    colorChooserButton = new JButton("Choose Color");
    toolComboBox = new JComboBox(new String[] {"Oval", "Fill"});
    currentColor = Color.black;
    image = new BufferedImage(PANEL_DIM.width, PANEL_DIM.height, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    g.setColor(Color.white);
    g.fillRect(0, 0, PANEL_DIM.width, PANEL_DIM.height);
    addMouseListener(this);
    addMouseMotionListener(this);
    colorChooserButton.addActionListener(this);
    add(colorChooserButton);
    add(toolComboBox);
    setPreferredSize(PANEL_DIM);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(this);
    frame.pack();
    frame.setResizable(false);
    frame.setVisible(true);
  }

  /**
   * Run program.
   *
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    new PaintBucket();
  }

  /**
   * Draws the image to the window.
   *
   * @param g graphics object to draw to
   */
  public final void paintComponent(final Graphics g) {
    g.drawImage(image, 0, 0, null);
    if (mouseDown && toolComboBox.getSelectedIndex() == 0) {
      drawOval(g);
    }
  }

  /**
   * Draw the most recently created oval based on mouse location.
   *
   * @param g the graphics object to draw to
   */
  private void drawOval(final Graphics g) {
    int shapeX, shapeY, shapeWidth, shapeHeight;
    if (mouseDownX < currentMouseX) {
      shapeX = mouseDownX;
    } else {
      shapeX = currentMouseX;
    }
    if (mouseDownY < currentMouseY) {
      shapeY = mouseDownY;
    } else {
      shapeY = currentMouseY;
    }
    shapeWidth = Math.abs(currentMouseX - mouseDownX);
    shapeHeight = Math.abs(currentMouseY - mouseDownY);
    g.setColor(currentColor);
    g.drawOval(shapeX, shapeY, shapeWidth, shapeHeight);
  }

  /**
   * Fill the region of the raster image at the specified coordinates with the specified color,
   * recursively.
   *
   * @param raster raster image
   * @param fillColor color to fill with
   * @param row row of raster to fill
   * @param col column of raster to fill
   */
  private void fill(final int[][] raster, final int fillColor, final int row, final int col) {
    // TODO: write fill method using recursion
  }

  /**
   * Returns the raster of the current panel image.
   *
   * @return raster of the current panel image
   */
  private int[][] getRaster() {
    int[][] raster = new int[image.getHeight()][image.getWidth()];
    for (int row = 0; row < image.getHeight(); row++) {
      for (int col = 0; col < image.getWidth(); col++) {
        raster[row][col] = image.getRGB(col, row);
      }
    }
    return raster;
  }

  /**
   * Set the panel's image to be the specified raster.
   *
   * @param raster raster to set the panel image to
   */
  private void setRaster(final int[][] raster) {
    for (int row = 0; row < image.getHeight(); row++) {
      for (int col = 0; col < image.getWidth(); col++) {
        image.setRGB(col, row, raster[row][col]);
      }
    }
  }

  /**
   * Unused.
   *
   * @param event mouse event
   */
  public void mouseClicked(final MouseEvent event) {}

  /**
   * Unused.
   *
   * @param event mouse event
   */
  public void mouseEntered(final MouseEvent event) {}

  /**
   * Unused.
   *
   * @param event mouse event
   */
  public void mouseExited(final MouseEvent event) {}

  /**
   * Update instance data to reflect mouse down location.
   *
   * @param event mouse event
   */
  public final void mousePressed(final MouseEvent event) {
    mouseDownX = event.getX();
    mouseDownY = event.getY();
    mouseDown = true;
  }

  /**
   * Draw oval or fill region when mouse is released.
   *
   * @param event mouse event
   */
  public final void mouseReleased(final MouseEvent event) {
    currentMouseX = event.getX();
    currentMouseY = event.getY();
    mouseDown = false;
    Graphics g = image.getGraphics();
    if (toolComboBox.getSelectedIndex() == 0) {
      drawOval(g);
    } else if (toolComboBox.getSelectedIndex() == 1) {
      int[][] raster = getRaster();
      fill(raster, currentColor.getRGB(), event.getY(), event.getX());
      setRaster(raster);
    }
    repaint();
  }

  /**
   * Update instance data when mouse is dragged.
   *
   * @param event mouse event
   */
  public final void mouseDragged(final MouseEvent event) {
    currentMouseX = event.getX();
    currentMouseY = event.getY();
    repaint();
  }

  /**
   * Unused.
   *
   * @param event mouse event
   */
  public void mouseMoved(final MouseEvent event) {}

  /**
   * Display color dialog on button press.
   *
   * @param event action event
   */
  public final void actionPerformed(final ActionEvent event) {
    Color newColor = JColorChooser.showDialog(null, "Choose a Color", currentColor);
    if (newColor != null) {
      currentColor = newColor;
    }
  }
}
