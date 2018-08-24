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
 * Servlet implementation class SelectFileInfoServlet
 */
@WebServlet("/SelectFileInfoServlet")
public class SelectFileInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectFileInfoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileid = request.getParameter("fileid");
		// System.out.println("getin this function");
		FileInfoDAO fileInfoDAO = new FileInfoDAO();
		String filename = fileInfoDAO.FindFileName(Integer.valueOf(fileid));
		if (filename == null) {
			request.setAttribute("errorMessage", "查找文件名失败");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			return;
		}
		int id = Integer.valueOf(fileid);
		FileInfo fileInfo = fileInfoDAO.searchFileInfo(id);
		if (fileInfo != null) {
			request.getSession().setAttribute("fileInfo", fileInfo);
			request.getRequestDispatcher("searchFileInfoPage.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "查询失败或无此编号文件");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
