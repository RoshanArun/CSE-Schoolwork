package FinalPrep;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import HW6.MyPanel;

import java.awt.event.ActionEvent;

public class Prep extends JFrame implements ActionListener {
	JTextField text2;

	public Prep() {
		super("FRAME");

		text2 = new JTextField("BRUHHH");

		JTabbedPane tabs = new JTabbedPane();
		JPanel one = new JPanel();
		MyPanel two = new MyPanel();

		tabs.add("HIIIII", one);
		tabs.add("BYEEEEE", two);

		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("MENU");
		bar.add(menu);

		JMenuItem item = new JMenuItem("ITEM ONE");
		JMenuItem item2 = new JMenuItem("ITEM Two");

		menu.add(item);
		menu.add(item2);
		setJMenuBar(bar);

		add(tabs);

		GridLayout grid = new GridLayout(5, 4);
		one.setLayout(grid);

		JButton but = new JButton("HIII");

		one.add(but);

		JRadioButton but2 = new JRadioButton("BYYYY", true);
		but2.setBorder(BorderFactory.createTitledBorder("WORK?"));

		one.add(but2);

		JCheckBox but3 = new JCheckBox("Test1", true);
		one.add(but3);

		JSlider slide = new JSlider();
		one.add(slide);

		JTextField text = new JTextField("TEST@@@@@");
		text.setBorder(BorderFactory.createLineBorder(Color.black));

		one.add(text);

		JTextArea area = new JTextArea("AREA");
		area.setBorder(BorderFactory.createLineBorder(Color.black));
		one.add(area);

		Object data[] = { "One", "two", "Three" };
		JList list = new JList(data);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		JComboBox combo = new JComboBox(data);
		one.add(combo);
		one.add(list);

		but.addActionListener(this);

		one.add(text2);
	}

	public void actionPerformed(ActionEvent yes) {
		text2.setText(text2.getText() + "HIII");
	}

	public static void main(String args[]) {
		Prep test = new Prep();
		test.setSize(500, 500);
		test.setVisible(true);
	}
}
