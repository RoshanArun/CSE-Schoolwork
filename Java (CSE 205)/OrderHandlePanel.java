import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


/**
 * Homework 03 Listeners
 * Student ID # 1221911327
 * @author Roshan Arun
 * Lecture Time - 10:30-11:45
 * Class Description - handles the input, and either removes or adds the order
 */

public class OrderHandlePanel extends JPanel implements ActionListener{
	DefaultListModel model;
	JTextArea test5;
	double total = 0;

	public OrderHandlePanel() {
		setLayout( new GridLayout(2, 3));
		model = new DefaultListModel();
		JList list = new JList(model);
		JScrollPane panel = new JScrollPane(list);
		panel.setBorder(BorderFactory.createTitledBorder("New Order"));
		add(panel);
		
		
		
		JButton but = new JButton("=>");
		JButton but2 = new JButton("<=");
		JPanel one = new JPanel();
		but.addActionListener(this);
		one.setLayout(new GridLayout(12, 1));
		one.add(but);
		one.add(but2);
		add(one);
		
		
		
		JScrollPane two = new JScrollPane();
		two.setBorder(BorderFactory.createTitledBorder("Cancelled Order"));
		add(two);
		
		
		
		test5 = new JTextArea("Ordered Amt: ");
		JPanel test6 = new JPanel();
		test6.add(test5);
		add(test6);
		
		JTextArea test4 = new JTextArea();
		JPanel test3 = new JPanel();
		test3.add(test4);
		add(test3);
		
		JTextArea test8 = new JTextArea("Cancelled Amt: ");
		JPanel test9 = new JPanel();
		test9.add(test8);
		add(test9);
	}
	

	public void update() {
		model.clear();
		
		for(int i = 0; i < OrderContainer.getPosition(); i++) {
			Order s = OrderContainer.getOrder(i);
			String line = "Name: " + s.getName();
			String line2 = "Quantity: " + s.getQuan();
			String line3 = "Price: " + s.getPrice();
			String line4 = "Total Cost: " + s.calc();
			String line5 = "\n";
			
			model.addElement(line);
			model.addElement(line2);
			model.addElement(line3);
			model.addElement(line4);
			model.addElement(line5);

			total = total + (s.getPrice() * s.getQuan());
			test5 = ;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
