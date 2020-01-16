package com.jgon.App;

import com.jgon.UI.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mf = new MainFrame();
                mf.setVisible(true);

            }
        });

        BufferedImage bf = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bf.createGraphics();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] allFonts = ge.getAllFonts();
        List<Font> fonts = Arrays.asList(allFonts);
        List<Font> retroFonts = fonts.stream().filter(font -> font.getName().equals("Px437 IBM VGA8")).collect(Collectors.toList());
        Font retroFont = retroFonts.get(0);
        Font newRetroFont = retroFont.deriveFont(16f);
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.BLACK);
        g2d.setFont(newRetroFont);
        g2d.drawString("Hello World!", 100, 100);
        // get metrics from the graphics
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        String[] chars = {	"!",
                "\"",
                "#",
                "$",
                "%",
                "&",
                "'",
                "(",
                ")",
                "*",
                "+",
                ",",
                "-",
                ".",
                "/",
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                ":",
                ";",
                "<",
                "=",
                ">",
                "?",
                "@",
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G",
                "H",
                "I",
                "J",
                "K",
                "L",
                "M",
                "N",
                "O",
                "P",
                "Q",
                "R",
                "S",
                "T",
                "U",
                "V",
                "W",
                "X",
                "Y",
                "Z",
                "[",
                "\\",
                "]",
                "^",
                "_",
                "`",
                "a",
                "b",
                "c",
                "d",
                "e",
                "f",
                "g",
                "h",
                "i",
                "j",
                "k",
                "l",
                "m",
                "n",
                "o",
                "p",
                "q",
                "r",
                "s",
                "t",
                "u",
                "v",
                "w",
                "x",
                "y",
                "z",
                "{",
                "|",
                "}",
                "~"
        };
        for(String s : chars) {
            int hgt = metrics.getHeight();
            int adv = metrics.stringWidth(s);
            //System.out.println("Character: " + s + " Height: " + hgt + " width: " + adv);
        }
    }
}
