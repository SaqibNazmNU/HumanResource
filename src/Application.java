import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Application extends JFrame {
	
	Application() {
		
		ArrayList<Employee> employees = getData();
		
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
		
		list.add(new Employee("Sam", "IT1", 25, Gender.Male, LocalDate.parse("2020-12-01"), "L2", "IT", "Senior Developer", "0155342391", "sam@gmail.com", new ImageIcon("images/photo1.jpg").getImage()));
		list.add(new Employee("Marry", "F1", 21, Gender.Female, LocalDate.parse("2018-10-20"), "L2", "Finance", "Manager", "8237483234", "marry@gmail.com", new ImageIcon("images/photo2.jpg").getImage()));
		list.add(new Employee("John", "M1", 25, Gender.Male, LocalDate.parse("2021-01-01"), "L1", "Marketing", "Assistant Manager", "9874943344", "john@gmail.com", new ImageIcon("images/photo3.jpg").getImage()));
		list.add(new Employee("David", "IT2", 25, Gender.Male, LocalDate.parse("2020-06-01"), "L1", "IT", "Junior Developer", "2398473298", "david@gmail.com", new ImageIcon("images/photo4.jpg").getImage()));
		
		
		return list;
	}
}
