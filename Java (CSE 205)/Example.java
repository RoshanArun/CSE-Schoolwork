import java.awt.*;
import javax.swing.*;    

public class Example extends JFrame{
	public Example() {
		super("Hello World Swing");
		GridLayout layout = new GridLayout(3, 3);
		setLayout (layout);
		JLabel label = new JLabel("Hello World");
		add(label);
		JButton button = new JButton("Click Me");
		add(button);
		JTextField text = new JTextField("text", 2);
		add(text);
		JCheckBox check = new JCheckBox("Option");
		add(check);
		
		
		JPanel panel = new JPanel();
		GridLayout panelLayout = new GridLayout(2, 2);
		panel.setLayout(panelLayout);
		
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		add(panel);
	}
	
	public static void main(String[] args) {
		Example frame = new Example();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
}
