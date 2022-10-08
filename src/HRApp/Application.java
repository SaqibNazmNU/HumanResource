/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HRApp;

import javax.swing.*;

/**
 *
 * @author Saqib Nazm
 */
public class Application extends JFrame {
	
	Application(){
		this.setTitle("Human Resource Management");
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add (new HomeView());
		this.pack();
		this.setVisible (true);
	}
	
	public static void main (String[] args) {
	
	}
}

