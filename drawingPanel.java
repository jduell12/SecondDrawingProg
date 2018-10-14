

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;

import second_shape_drawing.DrawType;
import second_shape_drawing.Drawing;
import second_shape_drawing.DrawingPanel;


public class DrawingPanel extends JPanel {
	
	Drawing drawing = new Drawing ();
	
	Image offScreenImage = null;
	Dimension screenDimension = null;
	
	//sets up the classes to capture the mouse events
	class MyMouseHandler extends MouseAdapter {
		public void mousePressed (MouseEvent e) {
			drawing.mousePressed(e.getPoint());
			repaint();
		}
		
		public void mouseReleased (MouseEvent e) {
			drawing.mouseReleased(e.getPoint());
			repaint();
		}
		
		public void mouseDragged (MouseEvent e) {
			drawing.mouseDragged(e.getPoint());
			repaint();
		}
	}
	
	//creates the JPanel screen
	DrawingPanel (){
		MyMouseHandler mmh = new MyMouseHandler();
		addMouseListener(mmh);
		addMouseMotionListener(mmh);
		
		setVisible(true);
	}
	

	public void paint (Graphics screen) {
		//creates a screen and a buffering image so that there is no flicker of the images to the viewer 
		Dimension dimen = getSize();
		if (offScreenImage == null || dimen.equals(screenDimension)) {
			screenDimension = dimen;
			offScreenImage = createImage(dimen.width, dimen.height);
		}
		Graphics g = offScreenImage.getGraphics();
		
		Insets insets = getInsets();
		int top = insets.top;
		int left = insets.left;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, dimen.width, dimen.height);
		
		drawing.draw(g);
		
		screen.drawImage(offScreenImage, 0, 0, this);
	}
	
	

}
