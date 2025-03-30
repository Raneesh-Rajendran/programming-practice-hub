package main.java.tool_coding.paint_bucket;

import java.awt.*;
import javax.swing.*;

public class PaintBucketFrame extends JFrame {

    public PaintBucketFrame() {
        this.setTitle("Paint Bucket Demo");
        this.setLayout(new BorderLayout());
        this.add(ImagePanelSingleton.INSTANCE, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new PaintBucketFrame();
    }
}