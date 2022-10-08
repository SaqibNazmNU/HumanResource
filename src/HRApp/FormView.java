/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HRApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Saqib Nazm
 */
public class FormView extends JPanel {
	
	
	private JTextField nameField;
	private JTextField idField;
	private JTextField ageField;
	private JTextField dateField;
	private JTextField levelField;
	private JTextField infoField;
	private JTextField positionField;
	private JButton saveButton;
	private JButton cancelButton;
	private JButton imageButton;
	private JTextField phoneField;
	private JTextField emailField;
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	
	public FormView(JFrame frame, ArrayList<Employee> employees, Employee employee) {
		//construct components
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
		
		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		
		imageButton = new JButton("Choose Photo");
		
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
		
		dateField.setToolTipText("dd/mm/YYYY");
		
		//adjust size and set layout
		setPreferredSize(new Dimension(700, 450));
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		
		//add components
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
		
		add(imageButton);
		add(saveButton);
		add(cancelButton);
		
		formatNumberField(ageField);
		
		//set component bounds (only needed by Absolute Positioning)
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
		
		
		cancelButton.addActionListener(e -> {
			JPanel contentPane = (JPanel) frame.getContentPane();
			contentPane.removeAll();
			if (employee == null) {
				contentPane.add(new HomeView(frame, employees));
			}
			contentPane.revalidate();
			contentPane.repaint();
		});
	}
	
	public static void formatNumberField(JTextField textField) {
		textField.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent keyEvent) {
				textField.setEditable((keyEvent.getKeyChar() >= '0' && keyEvent.getKeyChar() <= '9') || keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE);
			}
		});
	}
}