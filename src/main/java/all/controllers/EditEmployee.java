package all.controllers;

import java.io.IOException;

import all.dao.EmployeeDAO;
import all.dao.EmployeeDAOImplement;
import all.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {

  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        EmployeeDAO dao = new EmployeeDAOImplement();

        Employee emp = dao.getEmployeeById(id);

        request.setAttribute("employee", emp);

        request.getRequestDispatcher("/pages/admin/edit_employee.jsp")
               .forward(request, response);
    }
}