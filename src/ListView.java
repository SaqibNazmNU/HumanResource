import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListView extends JPanel {
	
	private final JComboBox<String> searchList;
	private final JTextField searchField;
	
	ListView(JFrame frame, ArrayList<Employee> employees) {
		
		setLayout(null);
		setBackground(new Color(252, 252, 252));
		
		JButton backButton = new JButton("Back");
		JLabel label1 = new JLabel("Search By:");
		
		searchList = new JComboBox<>(new String[]{"Name", "ID"});
		searchList.setToolTipText("Search By");
		
		searchField = new JTextField();
		JButton searchButton = new JButton("Search");
		
		JPanel listPanel = addToView(frame, employees);
		JScrollPane scrollPane = new JScrollPane(listPanel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(backButton);
		add(scrollPane);
		
		add(label1);
		add(searchList);
		add(searchField);
		add(searchButton);
		
		searchList.setBounds(320, 10, 100, 30);
		label1.setBounds(220, 10, 80, 30);
		searchButton.setBounds(580, 10, 100, 30);
		searchField.setBounds(440, 10, 120, 30);
		
		backButton.setBounds(10, 10, 100, 30);
		scrollPane.setBounds(0, 50, 700, 400);
		
		backButton.addActionListener(e -> {
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.removeAll();
			contentPane.add(new HomeView(frame, employees));
			contentPane.revalidate();
			contentPane.repaint();
		});
		
		searchButton.addActionListener(e -> {
			String value = searchField.getText();
			if (!value.equals("")) {
				ArrayList<Employee> filteredList = new ArrayList<>();
				
				if (searchList.getSelectedIndex() == 0) {
					for (Employee employee : employees) {
						if (employee.getName().equalsIgnoreCase(value)) {
							filteredList.add(employee);
						}
					}
				} else if (searchList.getSelectedIndex() == 1) {
					for (Employee employee : employees) {
						if (employee.getEmpId().equalsIgnoreCase(value)) {
							filteredList.add(employee);
						}
					}
				}
				
				if (filteredList.size() == 0) {
					JOptionPane.showMessageDialog(frame, "No Record Found", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					listPanel.removeAll();
					
					for (Employee employee : filteredList) {
						listPanel.add(new ItemPanel(frame, employees, employee));
					}
					
					listPanel.revalidate();
					listPanel.repaint();
				}
				
			}
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
