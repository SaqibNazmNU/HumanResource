/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HRApp;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Saqib Nazm
 */
public class HomeView extends JPanel {
	private JButton addButton;
	private JButton viewButton;
	private JButton exitButton;
	
	public HomeView() {
		//construct components
		addButton = new JButton ("Add New Employee");
		viewButton = new JButton ("View Records");
		exitButton = new JButton ("Exit");
		
		//adjust size and set layout
		setPreferredSize (new Dimension(700, 450));
		setLayout (null);
		
		//add components
		add (addButton);
		add (viewButton);
		add (exitButton);
		
		//set component bounds (only needed by Absolute Positioning)
		addButton.setBounds (275, 145, 150, 40);
		viewButton.setBounds (195, 205, 150, 40);
		exitButton.setBounds (260, 265, 150, 40);
	}
}

