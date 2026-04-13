package all.dao;

import java.util.List;


import all.model.Employee;

public interface EmployeeDAO {
	boolean addEmployee(Employee employee);

	Employee getEmployeeById(int employeeId);
	
	Employee getEmployeeByEMail(String email);

	List<Employee> getAllEmployees();
	
	boolean updateEmployeeName(int employeeId, String name);

	boolean updateEmployeeRole(int employeeId, String role);
	
	boolean updateEmployeePhone(int employeeId, String phone);

	boolean updateEmployeeSalary(int employeeId, double salary);

	boolean updateEmployee(Employee emp);
	
	boolean deleteEmployee(int employeeId);
	
	boolean updatePassword(int id, String password);

}
