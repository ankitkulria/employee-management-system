package all.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import all.dao.EmployeeDAO;
import all.dao.EmployeeDAOImplement;
import all.model.Employee;
import all.util.PasswordUtil;

@WebServlet("/ResetPassword")
public class ResetPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Employee user = (Employee) session.getAttribute("loggedInUser");

		if(user == null){
			response.sendRedirect("pages/login.jsp");
			return;
		}

		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		// 1️⃣ Check current password
		if(!PasswordUtil.verify(currentPassword, user.getPassword())){

			session.setAttribute("err","Current password is incorrect.");

			response.sendRedirect("pages/employee/reset_password.jsp");

			return;
		}

		// 2️⃣ Check new password match
		if(!newPassword.equals(confirmPassword)){

			session.setAttribute("err","New password and confirm password do not match.");

			response.sendRedirect("pages/employee/reset_password.jsp");

			return;
		}

		// 3️⃣ Encrypt new password
		String hashedPassword = PasswordUtil.hash(newPassword);

		EmployeeDAO dao = new EmployeeDAOImplement();

		boolean status = dao.updatePassword(user.getId(), hashedPassword);

		if(status){

			session.setAttribute("msg","Password updated successfully.");

		}else{

			session.setAttribute("err","Failed to update password.");

		}

		response.sendRedirect("DashboardServlet");

	}
}