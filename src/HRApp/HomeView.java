/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HRApp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Saqib Nazm
 */
public class HomeView extends JPanel {
	private JButton addButton;
	private JButton viewButton;
	private JButton exitButton;
	private JFrame frame;
	private ArrayList<Employee> employees;
	
	public HomeView(JFrame frame, ArrayList<Employee> employees) {
		
		this.frame = frame;
		this.employees = employees;
		
		//construct components
		addButton = new JButton("Add New Employee");
		viewButton = new JButton("View Records");
		exitButton = new JButton("Exit");
		
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
			contentPane.add(new FormView(frame,employees,null));
			contentPane.revalidate();
			contentPane.repaint();
		});
		
		viewButton.addActionListener(e -> {
		
		});
		
		exitButton.addActionListener(e -> {
			frame.dispose();
		});
	}
	
	
}