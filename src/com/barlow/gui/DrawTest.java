package com.barlow.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class DrawTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame= new DrawFrame();
			frame.setTitle("DrawTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class DrawFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawFrame() {
		add(new DrawComponent());
		pack();
	}

}

class DrawComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HIGTH = 400;

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// draw rectangle
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
		g2.draw(rect);

		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rect);
		g2.draw(elipse);

		g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		double radius = 150;

		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
		g2.draw(circle);

	}

	public Dimension getPreferredSize() {

		return new Dimension(DEFAULT_WIDTH, DEFAULT_HIGTH);
	}

}
