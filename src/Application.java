import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Application extends JFrame {
	
	private ArrayList<Employee> employees;
	
	Application() {
		
		employees = getData();
		
		setTitle("Human Resource Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new HomeView(this, employees));
		//getContentPane().add(new ListView());
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
	
	public static ArrayList<Employee> getData() {
		ArrayList<Employee> list = new ArrayList<>();
		
		list.add(new Employee("Sam", "E1", 25, Gender.Male, LocalDate.parse("2020-12-01"), "L2", "IT", "Senior Developer", "0155342391", "sam@gmail.com", new ImageIcon("photo.jpg").getImage()));
		list.add(new Employee("Sam", "E1", 25, Gender.Male, LocalDate.parse("2020-12-01"), "L2", "IT", "Senior Developer", "0155342391", "sam@gmail.com", new ImageIcon("photo.jpg").getImage()));
		list.add(new Employee("Sam", "E1", 25, Gender.Male, LocalDate.parse("2020-12-01"), "L2", "IT", "Senior Developer", "0155342391", "sam@gmail.com", new ImageIcon("photo.jpg").getImage()));
		list.add(new Employee("Sam", "E1", 25, Gender.Male, LocalDate.parse("2020-12-01"), "L2", "IT", "Senior Developer", "0155342391", "sam@gmail.com", new ImageIcon("photo.jpg").getImage()));
		
		
		return list;
	}
}
