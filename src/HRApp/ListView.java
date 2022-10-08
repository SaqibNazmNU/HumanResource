import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListView extends JPanel {
	
	private JFrame frame;
	private ArrayList<Employee> employees;
	private JScrollPane scrollPane;
	private JButton backButton;
	
	ListView(JFrame frame, ArrayList<Employee> employees) {
		
		this.employees = employees;
		this.frame = frame;
		
		setLayout(null);
		setBackground(new Color(252, 252, 252));
		
		backButton = new JButton("Back");
		
		scrollPane = new JScrollPane(addToView(frame, employees));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(backButton);
		add(scrollPane);
		
		backButton.setBounds(10, 10, 100, 30);
		scrollPane.setBounds(0, 50, 700, 400);
		
		backButton.addActionListener(e -> {
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.removeAll();
			contentPane.add(new HomeView(frame, employees));
			contentPane.revalidate();
			contentPane.repaint();
		});
	}
	
	public static JPanel addToView(JFrame frame, ArrayList<Employee> employees) {
		JPanel panel = new JPanel();
		
		for (Employee e : employees) {
			panel.add(new ItemPanel(frame, employees, e));
		}
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		return panel;
	}
	
}
