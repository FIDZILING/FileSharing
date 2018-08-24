package com.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FileInfoDAO {

	public String seeFileInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url1 = "jdbc:mysql://localhost:3306/filesharing";
			String url2 = "?user=root&password=123456";
			String url3 = "&useUnicode=true&characterEncoding=UTF-8";
			String url = url1 + url2 + url3;
			String rst1, rst2, rst3, rst4;
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement("SELECT id,name,creator,downloadTimes FROM fileinfo");
			rst = pstmt.executeQuery();
			String FileInfoTable = "<table id=\"table\" border=1>";
			FileInfoTable += "<tr><td>文件编号</td><td>文件名称</td><td>上传者</td><td>下载次数</td></tr>";
			while (rst.next()) {
				rst1 = rst.getString(1);
				rst2 = rst.getString(2);
				rst3 = rst.getString(3);
				rst4 = rst.getString(4);
				FileInfoTable += "<tr><td>" + rst1
						+ "</td><td><a href=\"/FileSharing/SelectFileInfo?fileid=" + rst1 + "\">"
						+ rst2 + "</a></td><td>" + rst3 + "</td><td>" + rst4 + "</td></tr>";
			}
			FileInfoTable += "</table>";
			return FileInfoTable;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				conn.close();
			} catch (Exception se) {
			}
		}
	}

	public FileInfo searchFileInfo(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		FileInfo fileInfo = new FileInfo();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url1 = "jdbc:mysql://localhost:3306/filesharing";
			String url2 = "?user=root&password=123456";
			String url3 = "&useUnicode=true&characterEncoding=UTF-8";
			String url = url1 + url2 + url3;
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement("SELECT * FROM fileinfo WHERE id=?");
			pstmt.setInt(1, id);
			rst = pstmt.executeQuery();
			if (rst.next()) {
				fileInfo.setId(rst.getInt("id"));
				fileInfo.setName(rst.getString("name"));
				fileInfo.setCreator(rst.getString("creator"));
				fileInfo.setDescription(rst.getString("description"));
				fileInfo.setDownloadTimes(rst.getInt("downloadTimes"));
				return fileInfo;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		} finally {
			try {
				conn.close();
			} catch (Exception se) {
			}
		}
	}

	public boolean insertFileInfo(int id, String name, String creator, String description) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url1 = "jdbc:mysql://localhost:3306/filesharing";
			String url2 = "?user=root&password=123456";
			String url3 = "&useUnicode=true&characterEncoding=UTF-8";
			String url = url1 + url2 + url3;
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement(
					"INSERT INTO fileinfo(id,name,creator,description,downloadTimes) VALUES(?,?,?,?,0)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, creator);
			pstmt.setString(4, description);
			int n = pstmt.executeUpdate();
			if (n == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		} finally {
			try {
				conn.close();
			} catch (Exception se) {
			}
		}
	}

	/*
	 * 顺便将下载量加1
	 */
	public String FindFileName(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url1 = "jdbc:mysql://localhost:3306/filesharing";
			String url2 = "?user=root&password=123456";
			String url3 = "&useUnicode=true&characterEncoding=UTF-8";
			String url = url1 + url2 + url3;
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement("SELECT * FROM fileinfo WHERE id=?");
			pstmt.setInt(1, id);
			rst = pstmt.executeQuery();
			if (rst.next()) {
				int dt = rst.getInt("downloadTimes");
				String name = rst.getString("name");
				dt++;
				if (downloadTimesADD(id, dt)) {
					return name;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		} finally {
			try {
				conn.close();
			} catch (Exception se) {
			}
		}
	}

	private boolean downloadTimesADD(int id, int dt) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url1 = "jdbc:mysql://localhost:3306/filesharing";
			String url2 = "?user=root&password=123456";
			String url3 = "&useUnicode=true&characterEncoding=UTF-8";
			String url = url1 + url2 + url3;
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement("UPDATE fileinfo SET downloadTimes=? WHERE id=?");
			pstmt.setInt(1, dt);
			pstmt.setInt(2, id);
			int n = pstmt.executeUpdate();
			if (n == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		} finally {
			try {
				conn.close();
			} catch (Exception se) {
			}
		}
	}
}
