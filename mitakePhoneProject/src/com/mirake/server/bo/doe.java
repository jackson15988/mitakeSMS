package com.mirake.server.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class doe {
			public static void main(String[] args) throws ClassNotFoundException {
				
				Connection conn;
				Statement stmt;
				Class.forName("com.mysql.cj.jdbc.Driver");
				// System.out.println("連接成功MySQLToJava");
				// 建立讀取資料庫 (test 為資料庫名稱; user 為MySQL使用者名稱; passwrod 為MySQL使用者密碼)
				String datasource = "jdbc:mysql://45.32.49.87:3306/myforex?user=root&password=36f57bc6fd&useSSL=false&serverTimezone=UTC";
				// 以下的資料庫操作請參考本blog中: "使用 Java 連結與存取 access 資料庫 (JDBC)"
				try {
					conn = DriverManager.getConnection(datasource);
					System.out.println("連接成功MySQL");
					stmt = conn.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
