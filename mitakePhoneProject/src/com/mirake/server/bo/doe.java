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
				// System.out.println("�s�����\MySQLToJava");
				// �إ�Ū����Ʈw (test ����Ʈw�W��; user ��MySQL�ϥΪ̦W��; passwrod ��MySQL�ϥΪ̱K�X)
				String datasource = "jdbc:mysql://45.32.49.87:3306/myforex?user=root&password=36f57bc6fd&useSSL=false&serverTimezone=UTC";
				// �H�U����Ʈw�ާ@�аѦҥ�blog��: "�ϥ� Java �s���P�s�� access ��Ʈw (JDBC)"
				try {
					conn = DriverManager.getConnection(datasource);
					System.out.println("�s�����\MySQL");
					stmt = conn.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
