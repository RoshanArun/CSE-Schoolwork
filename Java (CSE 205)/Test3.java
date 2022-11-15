
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.Applet;
// class extending applet component and implementing mouse event listener
public class paintest extends JFrame implements MouseListener {
	private Vector vector;
	public paintest() {
		vector = new Vector();
		setBackground(Color.red);
		addMouseListener(this);
	}
	
	public void paint(Graphics graphics) { // paint method implementation
		super.paint(graphics);
		graphics.setColor(Color.black);
		Enumeration enumeration = vector.elements();
		
		while(enumeration.hasMoreElements()) {
			Point p = (Point)(enumeration.nextElement());
			graphics.drawRect(p.x-20, p.y-20, 40, 40);
		}
	}
	
	public void mousePressed(MouseEvent mouseevent) {
		vector.add(mouseevent.getPoint());
		repaint(); // call repaint() method
	}
	
	public void mouseClicked(MouseEvent mouseevent) {}
	public void mouseEntered(MouseEvent mouseevent) {}
	public void mouseExited(MouseEvent mouseevent) {}
	public void mouseReleased(MouseEvent mouseevent) {}
	
	public static void main(String args[]) {
	paintest frame = new paintest(); // creating a jFrame object
	frame.getContentPane().add(new paintest());      // Adding Window
	frame.setTitle("Repaint Method Demo");       // set title of the window
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setSize(375, 250);    // set size of window
	frame.setVisible(true);        // set window as visible
	}
}