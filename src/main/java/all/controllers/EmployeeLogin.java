package all.controllers;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import all.dao.EmployeeDAO;
import all.dao.EmployeeDAOImplement;
import all.model.Employee;
import all.util.PasswordUtil;


@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email").trim();
		String password=request.getParameter("password");
		EmployeeDAO dao=new EmployeeDAOImplement();
		if(email!=null && !email.isBlank() )
		{
			Employee emp=dao.getEmployeeByEMail(email);
			if(emp!=null)
			{
				if(email.equals(emp.getEmail()))
				{
					if(PasswordUtil.verify(password, emp.getPassword()))
					{
						HttpSession session=request.getSession();
						session.setAttribute("loggedInUser", emp);
						session.setAttribute("isLoggedIn", true);
						
						 // determine role
	                    if (emp.getEmail().equalsIgnoreCase("kulriaankit25@gmail.com")) {
	                        session.setAttribute("role", "ADMIN");
	                    } else {
	                        session.setAttribute("role", "EMPLOYEE");
	                    }
	                    response.sendRedirect(request.getContextPath()+"/DashboardServlet");
						
						session.setMaxInactiveInterval(60);
					}
					else
					{
						request.setAttribute("err","Wrong Credentials");
						request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
					}
				}
			}
			else
			{
				request.setAttribute("err","Not Registered. Register First");
				request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
			}
			}
						
		}
	}

