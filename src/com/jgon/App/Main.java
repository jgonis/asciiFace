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
    }
}
