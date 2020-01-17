package com.jgon.UI.Listeners;

import com.jgon.ImageProcessing.ImageAlphabet;
import com.jgon.UI.MainPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainPanelMouseListener implements MouseMotionListener, MouseListener {
	private final MainPanel _mainPanel;
	private Point _startPoint;
	private Point _endPoint;
	private Rectangle _clampedRect;

	public MainPanelMouseListener(MainPanel panel) {
		_mainPanel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		_startPoint = e.getPoint();
		_clampedRect = new Rectangle(_startPoint.x, _startPoint.y,0, 0 );
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		_mainPanel.resetDragRect();
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		_endPoint = e.getPoint();
		boolean changed = false;
		int width = _clampedRect.width;
		int x = _clampedRect.x;
		if(Math.abs(_clampedRect.width - Math.abs(_startPoint.x - _endPoint.x)) >= ImageAlphabet.CHARACTER_WIDTH) {
			width = Math.abs(_startPoint.x - _endPoint.x);
			x = Math.min(_endPoint.x, _startPoint.x);
			changed = true;
		}
		int height = _clampedRect.height;
		int y = _clampedRect.y;
		if(Math.abs(_clampedRect.height - Math.abs(_startPoint.y - _endPoint.y)) >= ImageAlphabet.CHARACTER_HEIGHT) {
			height = Math.abs(_startPoint.y - _endPoint.y);
			y = Math.min(_endPoint.y, _startPoint.y);
			changed = true;
		}
		_clampedRect.setBounds(x,
				y,
				width,
				height);
		if(changed) {
			_mainPanel.setDragRect(_clampedRect.x, _clampedRect.y, _clampedRect.width, _clampedRect.height);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
