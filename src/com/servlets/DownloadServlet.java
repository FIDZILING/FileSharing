package com.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.FileInfoDAO;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.得到要下载的文件名称
		String fileid = request.getParameter("fileid");
		// System.out.println("getin this function");
		FileInfoDAO fileInfoDAO = new FileInfoDAO();
		String filename = fileInfoDAO.FindFileName(Integer.valueOf(fileid));
		if (filename == null) {
			request.setAttribute("errorMessage", "查找文件名失败");
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			return;
		}
		String idfilename = fileid + filename;
		// filename = new String(filename.getBytes("iso8859-1"), "utf-8"); // 解决中文乱码
		// 2.在c:/Users/lx/Desktop/upload目录下查找这个文件是否存在
		File file = new File("D:/", idfilename);
		if (file.exists()) {
			// 文件存在，完成下载

			// 下载注意事项1--设置下载文件的mimeType
			String mimeType = this.getServletContext().getMimeType(filename);
			response.setContentType(mimeType);

			// String agent = request.getHeader("user-agent");
			// if (agent.contains("MSIE")) {
			// IE浏览器
			// filename = URLEncoder.encode(filename, "utf-8");
			// } else {
			// 其它浏览器
			// filename = URLEncoder.encode(filename, "utf-8");
			// }

			// 下载注意事项2--永远是下载 设置以附件的形式进行打开下载
			response.setHeader("content-disposition", "attachment;filename=" + filename);

			FileInputStream fis = new FileInputStream(file); // 读取要下载文件的内容
			OutputStream os = response.getOutputStream();// 将要下载的文件内容通过输出流写回到浏览器
			int len = -1;
			byte[] b = new byte[1024 * 8];

			while ((len = fis.read(b)) != -1) {
				os.write(b, 0, len);
				os.flush();
			}
			os.close();
			fis.close();
			request.setAttribute("successMessage", "下载成功");
			request.getRequestDispatcher("/successPage.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "下载失败");
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
