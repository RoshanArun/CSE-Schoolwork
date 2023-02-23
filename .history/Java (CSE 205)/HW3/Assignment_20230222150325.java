package HW3;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * Homework 03 Listeners
 * Student ID # 1221911327
 * 
 * @author Roshan Arun
 *         Lecture Time - 10:30-11:45
 *         Class Description - Main method class
 */

public class Assignment extends JFrame implements ChangeListener {
	OrderHandlePanel output;

	// main gui screen
	Assignment() {
		super("Order Handling");
		JTabbedPane tabs = new JTabbedPane();
		OrderInputPanel input = new OrderInputPanel();
		output = new OrderHandlePanel();

		tabs.add("Input", input);
		tabs.add("output", output);
		add(tabs);

		tabs.addChangeListener(this);
	}

	/**
	 * @param args
	 */
	// displays gui screen
	public static void main(String[] args) {
		Assignment one = new Assignment();
		one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		one.setSize(580, 400);
		one.setVisible(true);
	}

	// updates screen
	public void stateChanged(ChangeEvent e) {
		output.update();
	}
}
