package com.jgon.UI;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {
    public MainPanel() {
        //this.setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Text
        Graphics2D g2d = (Graphics2D)g;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] allFonts = ge.getAllFonts();
        List<Font> fonts = Arrays.asList(allFonts);
        List<Font> retroFonts = fonts.stream().filter(font -> font.getName().equals("Px437 IBM VGA8")).collect(Collectors.toList());
        Font retroFont = retroFonts.get(0);
        Font newRetroFont = retroFont.deriveFont(16f);
        g2d.setColor(Color.BLACK);
        g2d.setFont(newRetroFont);
		FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
		System.out.println(metrics.getStringBounds("a", g2d));
		System.out.println(metrics.getStringBounds("A", g2d));
		g2d.drawString("Hello World!", 100, 12);
    }
}
