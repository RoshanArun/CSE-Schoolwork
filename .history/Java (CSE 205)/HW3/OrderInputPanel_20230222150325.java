package HW3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Homework 03 Listeners
 * Student ID # 1221911327
 * 
 * @author Roshan Arun
 *         Lecture Time - 10:30-11:45
 *         Class Description - Order input class, allows user to input
 *         information
 */

public class OrderInputPanel extends JPanel implements ActionListener {
	JTextField pText, numtext, pricetext, textName;
	JTextArea area, test;

	// creates the panel
	OrderInputPanel() {
		setLayout(new GridLayout(1, 2));
		new JLabel("Name");

		textName = new JTextField();
		JPanel grid = new JPanel();

		grid.setLayout(new GridLayout(12, 2));
		test = new JTextArea("");

		JLabel pName = new JLabel("Prod. Name:");
		pText = new JTextField();

		JLabel num = new JLabel("Quantity");
		numtext = new JTextField();

		JLabel price = new JLabel("Price($)");
		pricetext = new JTextField();

		grid.add(test);

		grid.add(pName);
		grid.add(pText);

		grid.add(num);
		grid.add(numtext);

		grid.add(price);
		grid.add(pricetext);

		JButton button = new JButton("Place an Order");
		button.addActionListener(this);

		grid.add(button);
		add(grid);

		area = new JTextArea("No order");
		add(area);

		area.setText("");

	}

	/**
	 * @param e
	 */
	// adds a actionlistener for the button, allows inputs to be correct before
	// entering into object
	public void actionPerformed(ActionEvent e) {
		int ordernum = 0;

		String name = pText.getText();
		String quan = numtext.getText();
		String num3 = pricetext.getText();

		if (name.equals("") || quan.equals("") || num3.equals("")) {
			test.setForeground(Color.RED);
			test.setText("Please fill all fields");
			return;
		}

		boolean test3 = quan.matches("[0-9.]*$");
		boolean test4 = num3.matches("[0-9.]*$");

		if (test3 == false || test4 == false) {
			test.setForeground(Color.RED);
			test.setText("Incorrect data format");
			return;
		}

		double num2 = Double.parseDouble(pricetext.getText());
		int quan2 = Integer.parseInt(numtext.getText());

		Order order = new Order(name, quan2, num2);

		for (int j = 0; j < 100; j++) {
			if (OrderContainer.getOrder(j) == null) {
				j = 101;
			}
			ordernum++;
		}

		for (int i = 0; i < ordernum; i++) {
			if (OrderContainer.getOrder(i) == (null)) {
				break;
			} else if ((OrderContainer.getOrder(i).getName().equals(name)) &&
					(OrderContainer.getOrder(i).getQuan() == (quan2)) &&
					(OrderContainer.getOrder(i).getPrice() == (num2))) {
				test.setForeground(Color.RED);
				test.setText("Order not added - duplicated");
				return;
			}

		}

		OrderContainer.addOrder(order);
		area.append(order.toString());

		pText.setText("");
		numtext.setText("");
		pricetext.setText("");
		test.setForeground(Color.RED);
		test.setText("Order Added");
	}
}
