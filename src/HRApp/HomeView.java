import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HomeView extends JPanel {
	
	public HomeView(JFrame frame, ArrayList<Employee> employees) {
		
		//construct components
		JButton addButton = new JButton("Add New Employee");
		JButton viewButton = new JButton("View Records");
		JButton exitButton = new JButton("Exit");
		
		//adjust size and set layout
		setPreferredSize(new Dimension(700, 450));
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		//add components
		add(addButton);
		add(viewButton);
		add(exitButton);
		
		//set component bounds (only needed by Absolute Positioning)
		addButton.setBounds(275, 145, 150, 40);
		viewButton.setBounds(275, 205, 150, 40);
		exitButton.setBounds(275, 265, 150, 40);
		
		addButton.addActionListener(e -> {
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.removeAll();
			contentPane.add(new FormView(frame, employees, null));
			contentPane.revalidate();
			contentPane.repaint();
		});
		
		viewButton.addActionListener(e -> {
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.removeAll();
			contentPane.add(new ListView(frame, employees));
			contentPane.revalidate();
			contentPane.repaint();
		});
		
		exitButton.addActionListener(e -> {
			frame.dispose();
		});
	}
	
	
}
