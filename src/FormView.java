import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class FormView extends JPanel {
	
	
	private JTextField nameField;
	private JTextField idField;
	private JTextField ageField;
	private JTextField dateField;
	private JTextField levelField;
	private JTextField infoField;
	private JTextField positionField;
	private final JButton saveButton;
	private final JButton cancelButton;
	private final JButton imageButton;
	private JTextField phoneField;
	private JTextField emailField;
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private final Employee employee;
	private final JFrame frame;
	private final ArrayList<Employee> employees;
	private Image currentImage = null;
	
	public FormView(JFrame frame, ArrayList<Employee> employees, Employee employee) {
		
		this.employee = employee;
		this.frame = frame;
		this.employees = employees;
		
		//construct components
		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		imageButton = new JButton("Choose Photo");
		
		
		//adjust size and set layout
		setPreferredSize(new Dimension(700, 450));
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		//add components
		setupLabels();
		setupFields();
		add(imageButton);
		add(saveButton);
		add(cancelButton);
		formatNumberField(ageField);
		
		cancelButton.addActionListener(e -> {
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.removeAll();
			if (employee == null)
				contentPane.add(new HomeView(frame, employees));
			else
				contentPane.add(new ListView(frame, employees));
			contentPane.revalidate();
			contentPane.repaint();
		});
		
		saveButton.addActionListener(e -> save());
		imageButton.addActionListener(e -> selectImage());
		maleRadio.addActionListener(e -> femaleRadio.setSelected(false));
		femaleRadio.addActionListener(e -> maleRadio.setSelected(false));
		
		if (employee != null) {
			setupEmployeeDetails();
		}
	}
	
	private void save() {
		String name = nameField.getText();
		if (name.equals("")) {
			showEmptyFieldError("Name");
			return;
		}
		
		String id = idField.getText();
		if (employee == null) {
			if (id.equals("")) {
				showEmptyFieldError("Employee ID");
				return;
			}
			if (checkDuplicateID(id)) {
				JOptionPane.showMessageDialog(this, "Employee ID already assigned. Enter new Employee ID", "Duplicate Employee ID Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		String ageStr = ageField.getText();
		if (ageStr.equals("")) {
			showEmptyFieldError("Age");
			return;
		}
		int age = Integer.parseInt(ageStr);
		
		Gender gender;
		if (maleRadio.isSelected())
			gender = Gender.Male;
		else
			gender = Gender.Female;
		
		String dateStr = dateField.getText();
		if (dateStr.equals("")) {
			showEmptyFieldError("Start Date");
			return;
		}
		LocalDate date;
		try {
			date = LocalDate.parse(dateStr);
		} catch (DateTimeParseException ignored) {
			JOptionPane.showMessageDialog(this, "Invalid Date Format.\nUse this format. YYYY-MM-DD", "Date Format Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String level = levelField.getText();
		if (level.equals("")) {
			showEmptyFieldError("Level");
			return;
		}
		
		String info = infoField.getText();
		if (info.equals("")) {
			showEmptyFieldError("Team Info");
			return;
		}
		
		String position = positionField.getText();
		if (position.equals("")) {
			showEmptyFieldError("Position Title");
			return;
		}
		
		String phone = phoneField.getText();
		if (phone.equals("")) {
			showEmptyFieldError("Phone No");
			return;
		}
		
		String email = emailField.getText();
		if (email.equals("")) {
			showEmptyFieldError("Email");
			return;
		}
		
		if (currentImage == null) {
			showEmptyFieldError("Photo");
			return;
		}
		
		if (employee == null) {
			Employee newEmployee = new Employee(name, id, age, gender, date, level, info, position, phone, email, currentImage);
			employees.add(newEmployee);
			JOptionPane.showMessageDialog(this, "Data saved successfully", "Data Saved", JOptionPane.INFORMATION_MESSAGE);
			
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.removeAll();
			contentPane.add(new HomeView(frame, employees));
			contentPane.revalidate();
			contentPane.repaint();
		} else {
			employee.setName(name);
			employee.setAge(age);
			employee.setGender(gender);
			employee.setStartDate(date);
			employee.setLevel(level);
			employee.setTeamInfo(info);
			employee.setPosition(position);
			employee.setPhone(phone);
			employee.setEmail(email);
			employee.setPhoto(currentImage);
			JOptionPane.showMessageDialog(this, "Record Updated successfully", "Data Saved", JOptionPane.INFORMATION_MESSAGE);
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.removeAll();
			contentPane.add(new ListView(frame, employees));
			contentPane.revalidate();
			contentPane.repaint();
		}
	}
	
	private boolean checkDuplicateID(String id) {
		
		for (Employee e : employees) {
			if (e.getEmpId().equalsIgnoreCase(id)) {
				return true;
			}
		}
		
		return false;
	}
	
	private void showEmptyFieldError(String field) {
		JOptionPane.showMessageDialog(this, field + " is missing.\nAll fields are required", "Empty Field Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private void setupEmployeeDetails() {
		nameField.setText(employee.getName());
		
		idField.setText(employee.getEmpId());
		idField.setEditable(false);
		idField.setToolTipText("ID can not be updated");
		
		ageField.setText(employee.getAge() + "");
		if (employee.getGender() == Gender.Male) {
			maleRadio.setSelected(true);
			femaleRadio.setSelected(false);
		} else {
			maleRadio.setSelected(false);
			femaleRadio.setSelected(true);
		}
		
		dateField.setText(employee.getStartDate().toString());
		levelField.setText(employee.getLevel());
		infoField.setText(employee.getTeamInfo());
		positionField.setText(employee.getPosition());
		phoneField.setText(employee.getPhone());
		emailField.setText(employee.getEmail());
		
		Image newImg = employee.getPhoto().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // scale it the smooth way
		imageButton.setIcon(new ImageIcon(newImg));
		currentImage = newImg;
	}
	
	private void setupFields() {
		nameField = new JTextField(5);
		idField = new JTextField(5);
		ageField = new JTextField(5);
		dateField = new JTextField(5);
		levelField = new JTextField(5);
		infoField = new JTextField(5);
		positionField = new JTextField(5);
		phoneField = new JTextField(5);
		emailField = new JTextField(5);
		maleRadio = new JRadioButton("Male");
		femaleRadio = new JRadioButton("Female");
		dateField.setToolTipText("YYYY-MM-DD");
		add(nameField);
		add(ageField);
		add(idField);
		add(dateField);
		add(levelField);
		add(infoField);
		add(positionField);
		add(maleRadio);
		add(femaleRadio);
		add(phoneField);
		add(emailField);
		nameField.setBounds(170, 40, 170, 30);
		idField.setBounds(170, 90, 170, 30);
		ageField.setBounds(170, 140, 170, 30);
		dateField.setBounds(170, 240, 170, 30);
		levelField.setBounds(170, 290, 170, 30);
		infoField.setBounds(170, 340, 170, 30);
		positionField.setBounds(170, 390, 170, 30);
		
		phoneField.setBounds(480, 240, 170, 30);
		emailField.setBounds(480, 290, 170, 30);
		
		maleRadio.setBounds(170, 190, 60, 30);
		femaleRadio.setBounds(240, 190, 70, 30);
		
		imageButton.setBounds(500, 40, 150, 150);
		saveButton.setBounds(550, 390, 100, 30);
		cancelButton.setBounds(430, 390, 100, 30);
	}
	
	private void setupLabels() {
		JLabel label1 = new JLabel("Name");
		JLabel label2 = new JLabel("Employee ID");
		JLabel label3 = new JLabel("Age");
		JLabel label4 = new JLabel("Gender");
		JLabel label5 = new JLabel("Start Date");
		JLabel label6 = new JLabel("Level");
		JLabel label7 = new JLabel("Team Info");
		JLabel label8 = new JLabel("Position Title");
		JLabel label9 = new JLabel("Phone");
		JLabel label10 = new JLabel("Email");
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
		label1.setBounds(50, 40, 100, 30);
		label2.setBounds(50, 90, 100, 30);
		label3.setBounds(50, 140, 100, 30);
		label4.setBounds(50, 190, 100, 30);
		label5.setBounds(50, 240, 100, 30);
		label6.setBounds(50, 290, 100, 30);
		label7.setBounds(50, 340, 100, 30);
		label8.setBounds(50, 390, 100, 30);
		label9.setBounds(360, 240, 100, 30);
		label10.setBounds(360, 290, 100, 30);
	}
	
	private void selectImage() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png"));
		int opt = fileChooser.showOpenDialog(frame);
		
		if (opt == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			
			if (isImage(file)) {
				ImageIcon icon = new ImageIcon(file.getPath());
				Image image = icon.getImage();
				Image newImg = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
				icon = new ImageIcon(newImg);
				
				imageButton.setIcon(icon);
				currentImage = newImg;
			} else {
				JOptionPane.showMessageDialog(frame, "Invalid Image", "Image Read Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static boolean isImage(File file) {
		try {
			return ImageIO.read(file) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void formatNumberField(JTextField textField) {
		textField.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent keyEvent) {
				textField.setEditable((keyEvent.getKeyChar() >= '0' && keyEvent.getKeyChar() <= '9') || keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE);
			}
		});
	}
}
