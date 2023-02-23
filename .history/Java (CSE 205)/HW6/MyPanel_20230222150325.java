package HW6;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	/**
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		g.drawLine(0, 0, 300, 300);
		g.drawOval(200, 200, 400, 400);

	}
}
