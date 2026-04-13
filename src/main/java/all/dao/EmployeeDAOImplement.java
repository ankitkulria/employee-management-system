package all.dao;

import java.sql.Connection;


//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import all.model.Employee;
import all.util.DBConnection;
import all.util.PasswordUtil;

public class EmployeeDAOImplement implements EmployeeDAO{

	@Override
	public boolean addEmployee(Employee employee) {
		String query="INSERT INTO employees(name,role,phone,salary,gender,is_married,email,password) VALUES(?,?,?,?,?,?,?,?)";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS))
		{
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getRole());
			ps.setString(3, employee.getPhone());
			ps.setDouble(4, employee.getSalary());
			ps.setString(5,employee.getGender());
			ps.setString(6, employee.getMarried());
			ps.setString(7, employee.getEmail());
			ps.setString(8, PasswordUtil.hash(employee.getPassword()));
			return ps.executeUpdate()==1;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		String query="SELECT * FROM employees WHERE id=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
				)
		{
			Employee emp=null;
			ps.setInt(1, employeeId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				emp=new Employee();
				emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                emp.setPhone(rs.getString("phone"));
                emp.setEmail(rs.getString("email"));
                emp.setGender(rs.getString("gender"));
                emp.setMarried(rs.getString("is_married"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setJoineddate(rs.getDate("joined_date").toLocalDate());
			}
			if(emp!=null)
				return emp;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees=new ArrayList<>();
		String query="SELECT * FROM employees";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery())
		{
			while(rs.next())
			{
				Employee emp=new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setRole(rs.getString("role"));
				emp.setPhone(rs.getString("phone"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setEmail(rs.getString("email"));
                emp.setGender(rs.getString("gender"));
                emp.setMarried(rs.getString("is_married"));
				emp.setJoineddate(rs.getDate("joined_date").toLocalDate());
				
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return employees;
	}
	
	@Override
	public boolean updateEmployeeName(int employeeId, String name) {
		String query="UPDATE employees SET name=? WHERE employee_id=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			ps.setString(1,name);
			ps.setInt(2, employeeId);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateEmployeeRole(int employeeId, String role) {
		String query="UPDATE employees SET role=? WHERE employee_id=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			ps.setString(1,role);
			ps.setInt(2, employeeId);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateEmployeePhone(int employeeId, String phone) {
		String query="UPDATE employees SET phone=? WHERE employee_id=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			ps.setString(1,phone);
			ps.setInt(2, employeeId);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateEmployeeSalary(int employeeId, double salary) {
		String query="UPDATE employees SET salary=? WHERE employee_id=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			ps.setDouble(1,salary);
			ps.setInt(2, employeeId);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		String query="DELETE FROM employees WHERE id=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			ps.setInt(1, employeeId);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee getEmployeeByEMail(String email) {
		String query="SELECT * FROM employees WHERE email=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
				)
		{
			Employee emp=null;
			ps.setString(1, email.trim());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				emp=new Employee();
				emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                emp.setPhone(rs.getString("phone"));
                emp.setEmail(rs.getString("email"));
                emp.setGender(rs.getString("gender"));
                emp.setMarried(rs.getString("is_married"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setJoineddate(rs.getDate("joined_date").toLocalDate());
                emp.setPassword(rs.getString("password"));
			}
			if(emp!=null)
				return emp;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean updateEmployee(Employee emp) {
		boolean status = false;
		String query = "UPDATE employees SET name=?, phone=?, role=?, gender=?, is_married=?, salary=? WHERE id=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
						{
			ps.setString(1, emp.getName());
	        ps.setString(2, emp.getPhone());
	        ps.setString(3, emp.getRole());
	        ps.setString(4, emp.getGender());
	        ps.setString(5, emp.getMarried());
	        ps.setDouble(6, emp.getSalary());
	        ps.setInt(7, emp.getId());

	        int row = ps.executeUpdate();
	        if(row > 0){
	            status = true;
	        }

	    } catch(Exception e){
	        e.printStackTrace();
	    }	    
		return status;
	}
	
	@Override
	public boolean updatePassword(int id, String password){

		boolean status = false;
		String query = "UPDATE employees SET password=? WHERE id=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			ps.setString(1,password);
			ps.setInt(2,id);

			int row = ps.executeUpdate();

			if(row > 0){
				status = true;
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
		return status;
	}
}
