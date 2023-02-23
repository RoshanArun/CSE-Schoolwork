package HW2;

import java.awt.*;
import javax.swing.*;

public class HomeworkTwo extends JFrame {
	public HomeworkTwo() {
		super("WindowTitle");

		GridLayout layout = new GridLayout(1, 1);
		setLayout(layout);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("MenuWidget1");
		JMenu menu2 = new JMenu("MenuWidget2");
		menuBar.add(menu);
		menuBar.add(menu2);
		setJMenuBar(menuBar);

		JPanel panel = new JPanel();
		GridLayout panelLayout = new GridLayout(2, 2);
		panel.setLayout(panelLayout);
		panel.setBorder(BorderFactory.createTitledBorder("PanelCaption"));

		JPanel panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createTitledBorder("Panel"));
		BorderLayout layout2 = new BorderLayout();
		panel2.setLayout(layout2);
		panel.add(panel2);

		Object data[] = { "Item 1                     ", "Item 2", "Item 3", "Item 4", "Item 5" };
		JList list = new JList(data);
		list.setBorder(BorderFactory.createLineBorder(Color.black));
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		panel2.add(list, BorderLayout.WEST);

		JRadioButton b1 = new JRadioButton("JRadioButton1");
		JRadioButton b2 = new JRadioButton("JRadioButton2");
		JRadioButton b3 = new JRadioButton("JRadioButton3");
		JRadioButton b4 = new JRadioButton("InactiveRadio");
		b4.setEnabled(false);
		JButton but = new JButton("Button");

		JPanel subPanel = new JPanel();
		subPanel.add(b1);
		subPanel.add(b2);
		subPanel.add(b3);
		subPanel.add(b4);
		subPanel.add(but);

		panel2.add(subPanel, BorderLayout.CENTER);
		add(panel);

		GridLayout border2 = new GridLayout(6, 1);
		JPanel SelectedTab = new JPanel();
		JPanel OtherTab = new JPanel();
		JTabbedPane tabs = new JTabbedPane();

		SelectedTab.setLayout(border2);
		tabs.add("Selected Tabs", SelectedTab);
		tabs.add("Other Tabs", OtherTab);

		JCheckBox c1 = new JCheckBox("UncheckedBox");
		JCheckBox c2 = new JCheckBox("CheckedBox", true);
		JCheckBox c3 = new JCheckBox("InactiveCheckBox");
		c3.setEnabled(false);

		SelectedTab.add(c1);
		SelectedTab.add(c2);
		SelectedTab.add(c3);

		JTextField text2 = new JTextField("");
		text2.setBorder(BorderFactory.createEmptyBorder());
		JTextField text3 = new JTextField("");
		text3.setBorder(BorderFactory.createEmptyBorder());
		SelectedTab.add(text2);
		SelectedTab.add(text3);
		JSlider s = new JSlider(0, 10);
		SelectedTab.add(s, BorderLayout.SOUTH);
		panel.add(tabs);

		GridLayout border4 = new GridLayout(12, 1);
		JPanel SelectedTab4 = new JPanel();
		SelectedTab4.setLayout(border4);

		JTextField text4 = new JTextField("TextField");
		text4.setBorder(BorderFactory.createLineBorder(Color.black));
		SelectedTab4.add(text4);
		JTextField text6 = new JTextField("");
		text6.setBorder(BorderFactory.createEmptyBorder());
		SelectedTab4.add(text6);

		JTextField text5 = new JTextField("********");
		text4.setBorder(BorderFactory.createLineBorder(Color.black));
		SelectedTab4.add(text5);
		JTextField text7 = new JTextField("");
		text7.setBorder(BorderFactory.createEmptyBorder());
		SelectedTab4.add(text7);

		Object data2[] = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
		JComboBox list2 = new JComboBox(data2);
		SelectedTab4.add(list2);
		panel.add(SelectedTab4);

		BorderLayout box4 = new BorderLayout();
		JPanel panel3 = new JPanel();
		panel3.setLayout(box4);
		JTextArea text8 = new JTextArea("TextArea");
		text8.setLineWrap(true);
		text8.setBorder(BorderFactory.createLineBorder(Color.black));
		panel3.add(text8, BorderLayout.CENTER);
		panel.add(panel3);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HomeworkTwo frame = new HomeworkTwo();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
