package all.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import all.dao.EmployeeDAO;
import all.dao.EmployeeDAOImplement;
import all.model.Employee;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        EmployeeDAO dao = new EmployeeDAOImplement();

        // get employee before deleting
        Employee emp = dao.getEmployeeById(id);

        boolean status = dao.deleteEmployee(id);

        HttpSession session = request.getSession();

        if(status){
            session.setAttribute("msg",
                "Employee " + emp.getName() + " (ID: " + emp.getId() + ") deleted successfully.");
        }else{
            session.setAttribute("err",
                "Failed to delete employee.");
        }

        response.sendRedirect("DashboardServlet");
    }
}