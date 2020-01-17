package com.jgon.ImageProcessing;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class ImageAlphabet {
    public static final HashMap<String, BufferedImage> Image_Alphabet;
    public static final Integer CHARACTER_WIDTH;
    private static final List<String> _alphabet = Arrays.asList( "!",
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
            "~");
    
    static {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] allFonts = ge.getAllFonts();
        List<Font> fonts = Arrays.asList(allFonts);
        Optional<Font> retroFonts = fonts.stream().filter(font -> font.getName().equals("Px437 IBM VGA8")).findFirst();
        Font retroFont = retroFonts.get().deriveFont(16f);
        BufferedImage scratchPad = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scratchPad.createGraphics();
        g2d.setFont(retroFont);
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        CHARACTER_WIDTH = metrics.stringWidth(_alphabet.get(0));;
        Image_Alphabet = new HashMap<>();

        for(String s : _alphabet) {
            int charHeight = metrics.getHeight();
            int charWidth = metrics.stringWidth(s);
            BufferedImage strikePlate = new BufferedImage(charWidth, charHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D imageG2d = strikePlate.createGraphics();
            imageG2d.setColor(Color.BLACK);
            imageG2d.fillRect(0, 0, strikePlate.getWidth(), strikePlate.getHeight());
            imageG2d.setColor(Color.WHITE);
            imageG2d.drawString(s, 0, strikePlate.getHeight());
            imageG2d.dispose();
            Image_Alphabet.put(s,strikePlate);
        }
    }
}
