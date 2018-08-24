package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Users;
import com.beans.UsersDAO;

/**
 * Servlet implementation class UsersLoginServlet
 */
@WebServlet("/UsersLoginServlet")
public class UsersLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UsersDAO usersDAO = new UsersDAO();
		int numlevel = usersDAO.login(name, password);
		if (numlevel == -1) {
			request.setAttribute("errorMessage", "用户名或者密码错误");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		} else {
			Users users = new Users(name, password, numlevel);
			request.getSession().setAttribute("users", users);
			request.getRequestDispatcher("/useroperator.jsp").forward(request, response);
		}
	}

}
