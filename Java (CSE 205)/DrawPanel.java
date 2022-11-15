import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.applet.Applet;
/**
 * Homework 05 Paint App
 * Student ID # 1221911327
 * @author Roshan Arun
 * Lecture Time - 10:30-11:45
 * Class Description - Draw Panel class, extends Jpanel, main drawing canvas
 */

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener{
	int x1, y1, x2, y2;
	
    protected static ArrayList<Shape> shape = new ArrayList<Shape>();
	
    //draws panel
	public DrawPanel() {
		setBackground(Color.CYAN);
		addMouseListener(this);
		addMouseMotionListener(this);		
	}
	
	//paints the components
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		for(Shape s : shape) {
			Color color = s.getColor();
			g.setColor(color);
			s.draw(g);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}
	
	//size of shape is decided
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		
		int px = Math.min(x1,x2);
	    int py = Math.min(y1,y2);
	    int pw=Math.abs(x1-x2);
	    int ph=Math.abs(y1-y2);
	    
	    if(Main.shp == 1) {
	    	shape.add(new Rect(px, py, pw, ph, Main.test));	
	    }
	    if(Main.shp == 2) {
			shape.add(new Circ(px, py, pw, ph, Main.test));
	    }
	    if(Main.shp == 3) {
			shape.add(new Arc(px, py, pw, ph, Main.test, 0, 40));
	    }
	    
		    
		System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2);
		repaint();
	}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	

}
