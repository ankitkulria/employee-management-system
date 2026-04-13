package all.controllers;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import all.dao.MenuItemDAO;
import all.dao.MenuItemDAOImplement;
import all.model.MenuItem;

@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuItemDAO dao=new MenuItemDAOImplement();
		List<MenuItem> menuList = dao.getAllElements();

		request.setAttribute("menuList", menuList);
		request.getRequestDispatcher("/pages/menu.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
