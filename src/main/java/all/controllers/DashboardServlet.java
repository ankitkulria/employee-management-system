package all.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import all.dao.EmployeeDAO;
import all.dao.EmployeeDAOImplement;
import all.model.Employee;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 			
 			HttpSession session = request.getSession(false);
 			if(session == null || session.getAttribute("loggedInUser") == null){
 	            response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
 	            return;
 	        }
 			Employee emp = (Employee) session.getAttribute("loggedInUser");
 			boolean isAdmin = emp.getEmail().equalsIgnoreCase("kulriaankit25@gmail.com");
 			EmployeeDAO dao = new EmployeeDAOImplement();
 			if(isAdmin){
 			    List<Employee> employees = dao.getAllEmployees();
 			   request.setAttribute("employeeList", employees);
 			  
 			}
 			else{

 			    request.setAttribute("employee", emp);
 			    
 			}
 			request.getRequestDispatcher("/pages/admin/dashboard.jsp")
            .forward(request, response);
	}
	}

