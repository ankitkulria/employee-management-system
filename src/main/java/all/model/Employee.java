package all.model;

import java.time.LocalDate;

	public class Employee {
	private int id;
	private String name;
	private String role;
	private String phone;
	private double salary;
	private String gender;
	private String isMarried;
	private String email;
	private String password;
	private LocalDate joineddate;
	public Employee(){}
	
public Employee(String name, String role, String phone, double salary, String email, String password,
			LocalDate joineddate) {
		this.name = name;
		this.role = role;
		this.phone = phone;
		this.salary = salary;
		this.email = email;
		this.password = password;
		this.joineddate = joineddate;
	}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public LocalDate getJoineddate() {
	return joineddate;
}
public void setJoineddate(LocalDate joineddate) {
	this.joineddate = LocalDate.now();
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getMarried() {
	return isMarried;
}

public void setMarried(String string) {
	this.isMarried = string;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

}
