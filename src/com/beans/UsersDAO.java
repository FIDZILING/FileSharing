package com.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersDAO {

	public int login(String name, String password) {
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
			pstmt = conn.prepareStatement("SELECT * FROM users WHERE name=?");
			pstmt.setString(1, name);
			rst = pstmt.executeQuery();
			if (rst.next()) {
				if (password.equals(rst.getString("password"))) {
					return rst.getInt("numLevel");
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		} catch (Exception e) {
			return -1;
		} finally {
			try {
				conn.close();
			} catch (Exception se) {
			}
		}
	}

	public boolean signup(String name, String password, int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url1 = "jdbc:mysql://localhost:3306/filesharing";
			String url2 = "?user=root&password=123456";
			String url3 = "&useUnicode=true&characterEncoding=UTF-8";
			String url = url1 + url2 + url3;
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement("INSERT INTO users(name,password,numLevel) VALUES(?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setInt(3, num);
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
	
	public boolean changepassword(String name,String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url1 = "jdbc:mysql://localhost:3306/filesharing";
			String url2 = "?user=root&password=123456";
			String url3 = "&useUnicode=true&characterEncoding=UTF-8";
			String url = url1 + url2 + url3;
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement("UPDATE users SET password=? WHERE name=?");
			pstmt.setString(1, password);
			pstmt.setString(2, name);
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
