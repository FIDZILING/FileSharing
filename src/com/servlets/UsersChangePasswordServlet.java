package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.UsersDAO;

/**
 * Servlet implementation class UsersChangePasswordServlet
 */
@WebServlet("/UsersChangePasswordServlet")
public class UsersChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersChangePasswordServlet() {
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
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String username = request.getParameter("username");
		UsersDAO usersDAO = new UsersDAO();
		if (-1 == usersDAO.login(username, oldpassword)) {
			request.setAttribute("errorMessage", "原密码不正确");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			return;
		} else  if (-1 != usersDAO.login(username, newpassword)) {
			request.setAttribute("errorMessage", "新旧密码重复");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			return;
		} else  if (usersDAO.changepassword(username, newpassword)) {
			request.setAttribute("successMessage", "修改密码成功");
			request.getRequestDispatcher("/successPage.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "修改密码失败");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}
	}

}
