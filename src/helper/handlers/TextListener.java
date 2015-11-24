package helper.handlers;

import java.awt.Color;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import view.basics.panes.*;
import controller.primary.MainControl;
import controller.secondary.drawings.TextDrawing;


public class TextListener extends MouseAdapter {

	private int startx;
	private int starty;
	private Component comp;

	public TextListener(Component comp) {
		this.comp = comp;
	}

	/*
	 * @Override public void mouseClicked(MouseEvent e) { startx = e.getX();
	 * starty = e.getY();
	 * 
	 * TextDrawing text = new TextDrawing(TextPane.messageText, TextPane.color,
	 * startx, starty);
	 * 
	 * MainControl.preview = text; MainControl.drawings.add(MainControl.preview);
	 * comp.repaint(); }
	 */

	@Override
	public void mouseReleased(MouseEvent e) {
		MainControl.drawings.add(MainControl.preview);
		MainControl.preview = null;
		comp.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startx = e.getX();
		starty = e.getY();

		TextDrawing text = new TextDrawing(TextPane.messageText,
				TextPane.color, TextPane.font, TextPane.size, TextPane.style,startx, starty);
		MainControl.preview = text;
		comp.repaint();
	}

/*	@Override
	public void mouseDragged(MouseEvent e) {
		double endx = e.getX();
		double endy = e.getY();

		double w = endx - startx;
		if (w == 0) {
			w = 0.1f;
		}
		double h = endy - starty;
		if (h == 0) {
			h = 0.1f;
		}
		Rectangle2D bound = MainControl.preview.getBounds2D();
		MainControl.preview.scale(w / bound.getWidth(), h / bound.getHeight());
		comp.repaint();
	}*/
}
