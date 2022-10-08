import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ItemPanel extends JPanel {
	
	private JButton imageButton;
	private JLabel nameLabel;
	private JLabel idLabel;
	private JLabel ageLabel;
	private JLabel genderLabel;
	private JLabel dateLabel;
	private JLabel levelLabel;
	private JLabel infoLabel;
	private JLabel positionLabel;
	private JLabel phoneLabel;
	private JLabel emailLabel;
	
	private JButton editButton;
	private JButton deleteButton;
	private ArrayList<Employee> employees;
	private Employee employee;
	private JFrame frame;
	
	public ItemPanel(JFrame frame, ArrayList<Employee> employees, Employee employee) {
		
		this.employees = employees;
		this.frame = frame;
		this.employee = employee;
		
		//construct components
		JLabel label1 = new JLabel("Name:");
		JLabel label2 = new JLabel("ID:");
		JLabel label3 = new JLabel("Age:");
		JLabel label4 = new JLabel("Gender:");
		JLabel label5 = new JLabel("Start Date:");
		JLabel label6 = new JLabel("Level:");
		JLabel label7 = new JLabel("Team Info:");
		JLabel label8 = new JLabel("Position Title:");
		JLabel label9 = new JLabel("Phone:");
		JLabel label10 = new JLabel("Email:");
		
		nameLabel = new JLabel(employee.getName());
		idLabel = new JLabel(employee.getEmpId());
		ageLabel = new JLabel(employee.getAge() + "");
		genderLabel = new JLabel(employee.getGender().toString());
		dateLabel = new JLabel(employee.getStartDate().toString());
		levelLabel = new JLabel(employee.getLevel());
		infoLabel = new JLabel(employee.getTeamInfo());
		positionLabel = new JLabel(employee.getPosition());
		phoneLabel = new JLabel(employee.getPhone());
		emailLabel = new JLabel(employee.getEmail());
		
		
		//adjust size and set layout
		setPreferredSize(new Dimension(660, 150));
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		
		Image newImg = employee.getPhoto().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		ImageIcon icon = new ImageIcon(newImg);
		
		imageButton = new JButton(icon);
		deleteButton = new JButton("Delete");
		editButton = new JButton("Edit");
		
		deleteButton.setBackground(new Color(176, 65, 65));
		editButton.setBackground(new Color(196, 145, 99));
		
		//add components
		add(imageButton);
		add(deleteButton);
		add(editButton);
		
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(label7);
		add(label8);
		add(label9);
		add(label10);
		
		add(nameLabel);
		add(idLabel);
		add(ageLabel);
		add(genderLabel);
		add(dateLabel);
		add(levelLabel);
		add(infoLabel);
		add(positionLabel);
		add(phoneLabel);
		add(emailLabel);
		
		//set component bounds (only needed by Absolute Positioning)
		imageButton.setBounds(10, 10, 100, 100);
		
		label1.setBounds(120, 10, 60, 25);
		label2.setBounds(120, 35, 60, 25);
		label3.setBounds(120, 60, 60, 25);
		label4.setBounds(120, 85, 60, 25);
		label5.setBounds(350, 10, 60, 25);
		label6.setBounds(350, 35, 60, 25);
		label7.setBounds(350, 60, 60, 25);
		label8.setBounds(330, 85, 80, 25);
		label9.setBounds(10, 115, 50, 25);
		label10.setBounds(170, 115, 50, 25);
		
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		label4.setHorizontalAlignment(SwingConstants.RIGHT);
		label5.setHorizontalAlignment(SwingConstants.RIGHT);
		label6.setHorizontalAlignment(SwingConstants.RIGHT);
		label7.setHorizontalAlignment(SwingConstants.RIGHT);
		label8.setHorizontalAlignment(SwingConstants.RIGHT);
		label9.setHorizontalAlignment(SwingConstants.RIGHT);
		label10.setHorizontalAlignment(SwingConstants.RIGHT);
		
		nameLabel.setBounds(200, 10, 110, 25);
		idLabel.setBounds(200, 35, 110, 25);
		ageLabel.setBounds(200, 60, 110, 25);
		genderLabel.setBounds(200, 85, 110, 25);
		
		dateLabel.setBounds(430, 10, 150, 25);
		levelLabel.setBounds(430, 35, 150, 25);
		infoLabel.setBounds(430, 60, 150, 25);
		positionLabel.setBounds(430, 85, 150, 25);
		
		phoneLabel.setBounds(70, 115, 90, 25);
		emailLabel.setBounds(230, 115, 180, 25);
		
		editButton.setBounds(430, 115, 100, 25);
		deleteButton.setBounds(540, 115, 100, 25);
		
		editButton.addActionListener(e -> {
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.removeAll();
			contentPane.add(new FormView(frame, employees, employee));
			contentPane.revalidate();
			contentPane.repaint();
		});
		
		deleteButton.addActionListener(e -> {
			int opt = JOptionPane.showConfirmDialog(frame,  "Do you want to delete this record?","Confirm Deletion", JOptionPane.YES_NO_OPTION);
			if (opt == JOptionPane.YES_OPTION) {
				employees.remove(employee);
				JPanel contentPane = (JPanel) frame.getContentPane();
				contentPane.removeAll();
				contentPane.add(new ListView(frame, employees));
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
	}
}
