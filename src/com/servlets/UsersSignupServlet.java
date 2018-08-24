package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.UsersDAO;

/**
 * Servlet implementation class UsersSignupServlet
 */
@WebServlet("/UsersSignupServlet")
public class UsersSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersSignupServlet() {
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
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		if (password1.equals(password2)) {
			UsersDAO usersDAO = new UsersDAO();
			if (usersDAO.signup(name, password1, 1)) {
				request.getRequestDispatcher("/first.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "注册错误");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "密码不同");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}
	}

}
