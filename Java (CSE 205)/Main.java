import javax.swing.*;
import java.awt.*;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Homework 05 Paint App
 * Student ID # 1221911327
 * @author Roshan Arun
 * Lecture Time - 10:30-11:45
 * Class Description - Main method class
 */

public class Main extends JFrame implements ActionListener{
		protected static Color test;
		protected static int shp = 1;
		protected static int del;
	
		public Main() {
		super("My Paint App");
		
		//south
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.CYAN);
		JButton b1 = new JButton("Undo");
		JButton b2 = new JButton("Erase");
		southPanel.add(b1);
		southPanel.add(b2);
		
		//West
		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.PINK);
		String[] colors = {"Black", "Red", "Blue", "Green", "Yellow", "Orange", "Pink"};
		JComboBox list = new JComboBox(colors);
		
		JRadioButton rectangle = new JRadioButton("Rectangle");
		JRadioButton circle = new JRadioButton("Circle");
		JRadioButton arc = new JRadioButton("Arc");
		rectangle.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rectangle);
		group.add(circle);
		group.add(arc);
		
		GridLayout grid = new GridLayout(7, 1);
		westPanel.setLayout(grid);
		westPanel.add(list);
		westPanel.add(rectangle);
		westPanel.add(circle);
		westPanel.add(arc);
		
		//center
		JPanel centerPanel = new DrawPanel();
		centerPanel.setBackground(Color.CYAN);
		
		//frame
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		add(southPanel, BorderLayout.SOUTH);
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		
		//listeners
		list.addActionListener(this);
		rectangle.addActionListener(this);
		circle.addActionListener(this);
		arc.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}
	
		//based on user choices, certain acttions will be performed
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equals("comboBoxChanged")) {
			JComboBox tmp = (JComboBox) e.getSource();
			
			if(tmp.getSelectedItem().equals("Black")) {
				setColor(Color.black);
			}
			if(tmp.getSelectedItem().equals("Red")) {
				setColor(Color.red);			
			}
			if(tmp.getSelectedItem().equals("Blue")) {
				setColor(Color.blue);			
			}
			if(tmp.getSelectedItem().equals("Green")) {
				setColor(Color.green);			
			}
			if(tmp.getSelectedItem().equals("Yellow")) {
				setColor(Color.yellow);			
			}
			if(tmp.getSelectedItem().equals("Orange")) {
				setColor(Color.orange);			
			}
			if(tmp.getSelectedItem().equals("Pink")) {
				setColor(Color.pink);			
			}
		}	
		if(e.getActionCommand().equals("Rectangle")){
			setShp(1);
		}
		if(e.getActionCommand().equals("Circle")){
			setShp(2);
		}
		if(e.getActionCommand().equals("Arc")){
			setShp(3);
		}
		if(e.getActionCommand().equals("Undo")){
			delShape();
		}
		if(e.getActionCommand().equals("Erase")){
			delAllShapes();
		}
	}
	
	//sets the color
	public Color setColor(Color color) {
		test = color;
		return test;
	}
	
	//sets the shape
	public int setShp(int shape) {
		shp = shape;
		return shp;
	}
	
	//deletes last drawn shape
	public void delShape() {
		int one = DrawPanel.shape.size() - 1;
		DrawPanel.shape.remove(one);
		repaint();
	} 
	
	//deletes all shapes
	public void delAllShapes() {
		DrawPanel.shape.clear();
		repaint();
	} 

	//main method
	public static void main(String[] args) {
		Main frame = new Main(); // creating a jFrame object
		frame.getContentPane().add(new DrawPanel());      // Adding Window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 500);    // set size of window
		frame.setVisible(true);        // set window as visible
	}
	
	//gets color
	public Color getColor() {
		System.out.println(test);
        return test;
    }

}
