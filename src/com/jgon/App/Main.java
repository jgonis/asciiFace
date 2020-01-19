package com.jgon.App;

import com.jgon.ImageProcessing.ImageAlphabet;
import com.jgon.ImageProcessing.ImageToCharacterMutator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ImageToCharacterMutator img = new ImageToCharacterMutator();
        try {
            File imageFile = new File("C:/Users/jeffg_000/Desktop/rachel1.jpg");
            BufferedImage rachelImage = ImageIO.read(imageFile);
            int imageWidth = rachelImage.getWidth();
            int imageHeight = rachelImage.getHeight();
            while(imageWidth % ImageAlphabet.CHARACTER_WIDTH != 0) {
                imageWidth--;
            }
            while(imageHeight % ImageAlphabet.CHARACTER_HEIGHT != 0) {
                imageHeight--;
            }
            BufferedImage workImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = workImage.createGraphics();
            g2d.drawImage(rachelImage, 0, 0, imageWidth, imageHeight, null);
            g2d.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        SwingUtilities.invokeLater(() -> {
//            MainFrame mf = new MainFrame();
//            mf.setVisible(true);
//        });
    }
}
