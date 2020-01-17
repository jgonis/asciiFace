package com.jgon.UI.Listeners;

import com.jgon.UI.MainPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

public class MainPanelMouseListener implements MouseMotionListener, MouseListener {
	private final MainPanel _mainPanel;
	private Point _startPoint;
	private Point _endPoint;

	public MainPanelMouseListener(MainPanel panel) {
		_mainPanel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		_startPoint = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		_mainPanel.setDragRect(null);
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
		_mainPanel.setDragRect(new Rectangle(Math.min(_endPoint.x, _startPoint.x),
				Math.min(_endPoint.y, _startPoint.y),
				Math.abs(_startPoint.x - _endPoint.x),
				Math.abs(_startPoint.y - _endPoint.y)));
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
