package all.controllers;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.time.LocalDate;

import all.dao.EmployeeDAO;
import all.dao.EmployeeDAOImplement;
import all.model.Employee;

@WebServlet("/EmployeeRegister")
public class EmployeeRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("name").trim();
		String role=request.getParameter("role").trim();
		String phone=request.getParameter("phone").trim();
		Double salary=Double.parseDouble(request.getParameter("salary"));
		String gender=request.getParameter("gender").trim();
		String isMarried=request.getParameter("isMarried").trim();
		String email=request.getParameter("email").trim();
		String password=request.getParameter("password").trim();
		LocalDate joinedDate = LocalDate.parse(request.getParameter("joineddate"));
		
		EmployeeDAO dao=new EmployeeDAOImplement();
		Employee alreadyEmp=dao.getEmployeeByEMail(email);
		if(alreadyEmp!=null)
		{
			request.setAttribute("err", "Already Registered!");
			request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
		}
		else
		{
			Employee emp=new Employee();
			emp.setName(name);
			emp.setRole(role);
			emp.setPhone(phone);
			emp.setSalary(salary);
			emp.setGender(gender);
			emp.setMarried(isMarried);
			emp.setEmail(email);
			emp.setPassword(password);
			emp.setJoineddate(joinedDate);
			
			boolean added=dao.addEmployee(emp);
			
			if(added)
			{
				request.setAttribute("success", "Registered Successfully, You can LOGIN now");
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("err", "Something Went Wrong! Unable to Register");
				request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
			}
		}
	}

}
