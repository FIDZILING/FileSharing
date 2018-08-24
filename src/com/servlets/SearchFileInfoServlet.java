package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.FileInfo;
import com.beans.FileInfoDAO;

/**
 * Servlet implementation class SearchFileInfoServlet
 */
@WebServlet("/SearchFileInfoServlet")
public class SearchFileInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchFileInfoServlet() {
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
		String idS = request.getParameter("id");
		if (idS.length() == 0) {
			request.setAttribute("errorMessage", "未输入编号");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			return;
		}
		int id = Integer.valueOf(idS);
		FileInfoDAO fileInfoDAO = new FileInfoDAO();
		FileInfo fileInfo = fileInfoDAO.searchFileInfo(id);
		if (fileInfo != null) {
			request.getSession().setAttribute("fileInfo", fileInfo);
			request.getRequestDispatcher("searchFileInfoPage.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "查询失败或无此编号文件");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}
	}

}
