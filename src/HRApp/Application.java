/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HRApp;

import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author Saqib Nazm
 */

public class Application extends JFrame {
	
	private ArrayList<Employee> employees;
	
	Application() {
		
		employees = new ArrayList<>();
		
		setTitle("Human Resource Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new HomeView(this, employees));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		changeTheme("Nimbus");
		new Application();
	}
	
	public static void changeTheme(String theme) {
		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if (theme.equals(info.getName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
				         UnsupportedLookAndFeelException ignored) {
					
				}
				break;
			}
		}
	}
}
