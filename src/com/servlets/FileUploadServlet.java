package com.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.beans.FileInfoDAO;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.创建DiskFileItemFactory
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2.创建
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// 底层通过request获取数据，进行解析，将解析的数据封装到List<FileItem>
			List<FileItem> items = upload.parseRequest(request);
			// 获得相关数据先进行数据库操作
			String creator = items.get(0).getString("utf-8");
			String id = items.get(1).getString("utf-8");
			String description = items.get(2).getString("utf-8");
			String name = items.get(3).getName();
			name = name.substring(name.lastIndexOf("\\") + 1);
			// System.out.println(creator);
			// System.out.println(description);
			// System.out.println(name);
			FileInfoDAO fileInfoDAO = new FileInfoDAO();
			if (!fileInfoDAO.insertFileInfo(Integer.valueOf(id), name, creator, description)) {
				request.setAttribute("errorMessage", "插入文件信息失败");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
				return;
			}
			// 3.遍历集合
			// if (item.isFormField()) {
			// // 是表单组件 就得到了 <input type="text" name="content"> 这样的组件
			// String fieldName = item.getFieldName();
			// System.out.println(fieldName);
			//
			// // 上传文件的名称
			// String name = item.getName();
			// System.out.println(name);
			//
			// // String string = item.getString();
			// // System.out.println(string);
			// }
			// 不是表单组件 这就得到了<input type="file" name="f"> 这样的组件
			// String fieldName = items.get(3).getFieldName();
			// System.out.println("上传组件的名称: " + fieldName);

			// 上传文件的名称
			// String name = items..getName();
			// name = name.substring(name.lastIndexOf("\\") + 1);
			// System.out.println(name);
			//
			// String string = item.getString();
			// System.out.println(string);

			// 获取上传文件内容,完成文件上传操作
			// InputStream is = item.getInputStream();
			// byte[] b = new byte[1024];
			// int len = -1;
			FileOutputStream fos = new FileOutputStream("D:/" + id + name);
			// while ((len = is.read(b)) != -1) {
			// // System.out.println(new String(b, 0, len));
			// fos.write(b, 0, len);
			// }
			// is.close();
			IOUtils.copy(items.get(3).getInputStream(), fos);
			fos.close();
			items.get(3).delete();
			request.setAttribute("successMessage", "上传成功");
			request.getRequestDispatcher("/successPage.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("errorMessage", "上传失败");
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
