import java.awt.*;
import java.time.LocalDate;

public class Employee {
	private String name;
	private String empId;
	private int age;
	private Gender gender;
	private LocalDate startDate;
	private String level;
	private String teamInfo;
	private String position;
	private String phone;
	private String email;
	private Image photo;
	
	public Employee(String name, String empId, int age, Gender gender, LocalDate startDate, String level, String teamInfo, String position, String phone, String email, Image photo) {
		this.name = name;
		this.empId = empId;
		this.age = age;
		this.gender = gender;
		this.startDate = startDate;
		this.level = level;
		this.teamInfo = teamInfo;
		this.position = position;
		this.phone = phone;
		this.email = email;
		this.photo = photo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmpId() {
		return empId;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getTeamInfo() {
		return teamInfo;
	}
	
	public void setTeamInfo(String teamInfo) {
		this.teamInfo = teamInfo;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Image getPhoto() {
		return photo;
	}
	
	public void setPhoto(Image photo) {
		this.photo = photo;
	}
}


enum Gender{
	Male,
	Female,
}