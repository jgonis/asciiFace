package com.jgon.UI;

import com.jgon.UI.Listeners.MainPanelMouseListener;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
	public static final Color DRAG_RECT_FILL_COLOR = new Color(100, 100, 200, 100);
	private Rectangle _dragRect;

    public MainPanel() {
		this.setBackground(Color.BLACK);
	    MainPanelMouseListener mouseListener = new MainPanelMouseListener(this);
	    this.addMouseMotionListener(mouseListener);
	    this.addMouseListener(mouseListener);
	}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        // Draw Text
	    if(_dragRect != null) {
		    Graphics2D g2d = (Graphics2D) g;
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
	    }
    }

	public void setDragRect(Rectangle _dragRect) {
		this._dragRect = _dragRect;
		this.repaint();
	}
}
