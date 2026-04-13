package all.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import all.dao.EmployeeDAO;
import all.dao.EmployeeDAOImplement;
import all.model.Employee;

@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String role = request.getParameter("role");
		String gender = request.getParameter("gender");
		String married = request.getParameter("married");
		double salary = Double.parseDouble(request.getParameter("salary"));

		Employee emp = new Employee();

		emp.setId(id);
		emp.setName(name);
		emp.setPhone(phone);
		emp.setRole(role);
		emp.setGender(gender);
		emp.setMarried(married);
		emp.setSalary(salary);

		EmployeeDAO dao = new EmployeeDAOImplement();

		boolean status = dao.updateEmployee(emp);

		HttpSession session = request.getSession();

		if(status){
			session.setAttribute("msg",
			"Employee "+name+" (ID: "+id+") updated successfully.");
		}else{
			session.setAttribute("err",
			"Failed to update employee.");
		}

		response.sendRedirect("DashboardServlet");
	}
}