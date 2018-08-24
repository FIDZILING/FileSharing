package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.FileInfoDAO;

/**
 * Servlet implementation class SeeAllFileInfoServlet
 */
@WebServlet(name = "SeeAllFileInfoServlets", urlPatterns = { "/SeeAllFileInfoServlets" })
public class SeeAllFileInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeeAllFileInfoServlet() {
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
		FileInfoDAO fileInfoDAO = new FileInfoDAO();
		String FileInfoTable = fileInfoDAO.seeFileInfo();
		if (FileInfoTable == null) {
			request.setAttribute("errorMessage", "获取失败");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		} else {
			request.setAttribute("FileInfoTable", FileInfoTable);
			request.getRequestDispatcher("/seeAllFileInfoPage.jsp").forward(request, response);
		}

	}

}
