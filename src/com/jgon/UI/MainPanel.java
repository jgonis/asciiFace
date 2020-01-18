package com.jgon.UI;

import com.jgon.ImageProcessing.ImageAlphabet;
import com.jgon.UI.Listeners.MainPanelMouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MainPanel extends JPanel {
	public static final Color DRAG_RECT_FILL_COLOR = new Color(100, 100, 200, 100);
	private Rectangle _dragRect;
	private BufferedImage _rachelImage;

	public MainPanel() {
		this.setBackground(Color.BLACK);
	    MainPanelMouseListener mouseListener = new MainPanelMouseListener(this);
	    this.addMouseMotionListener(mouseListener);
	    this.addMouseListener(mouseListener);
	    try {
		    File imageFile = new File("C:/Users/jeffg_000/Desktop/rachel1.jpg");
		    _rachelImage = ImageIO.read(imageFile);
		    this.setPreferredSize(new Dimension(_rachelImage.getWidth(), _rachelImage.getHeight()));
	    } catch (IOException e) {
		    e.printStackTrace();
	    }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.drawImage(_rachelImage, 0, 0, null);
        // Draw Text
	    if(_dragRect != null) {
		    g2d.setStroke(new BasicStroke(2));
		    g2d.setColor(DRAG_RECT_FILL_COLOR);
		    g2d.fillRect(this._dragRect.x,
				    this._dragRect.y,
				    this._dragRect.width,
				    this._dragRect.height);
		    g2d.setColor(Color.BLUE);
		    g2d.drawRect(this._dragRect.x,
				    this._dragRect.y,
				    this._dragRect.width,
				    this._dragRect.height);
		    fillRectWithRandomText(g2d, _dragRect);
	    }
    }

	private void fillRectWithRandomText(Graphics2D g2d, Rectangle rect) {
    	int columns = rect.width / ImageAlphabet.CHARACTER_WIDTH;
    	int rows = rect.height / ImageAlphabet.CHARACTER_HEIGHT;
		Random rand = new Random();
		g2d.setColor(Color.WHITE);
		g2d.setFont(ImageAlphabet.RETRO_FONT);
    	for(int row = 0; row < rows; row++) {
    		for(int column = 0; column < columns; column++) {
    			String s = ImageAlphabet.ALPHABET.get(rand.nextInt(ImageAlphabet.ALPHABET.size()));
    			g2d.drawString(s,
						rect.x + (column * ImageAlphabet.CHARACTER_WIDTH),
						rect.y + (ImageAlphabet.CHARACTER_HEIGHT + (row * ImageAlphabet.CHARACTER_HEIGHT)));
			}
		}

	}

	public void setDragRect(int x, int y, int width, int height) {
    	if(_dragRect == null) {
    		_dragRect = new Rectangle();
		}
		this._dragRect.setBounds(x, y, width, height);
		this.repaint();
	}

	public void resetDragRect() {
    	this._dragRect = null;
	}
}
