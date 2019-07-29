package com.mirake;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirake.server.bo.mirakeBo;

/**
 * Servlet implementation class memberlogin
 */
@WebServlet("/memberlogin")
public class memberlogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = null;
		try {
			code = mirakeBo.verificationAccount(username, password);
		} catch (SQLException e) {

		}

		if (code.equals("-1")) {
			request.setAttribute("errorMessage", "帳號密碼發生錯誤!"); 
			request.getRequestDispatcher("sign-in.jsp").forward(request, response);

		}else{
			request.getSession().setAttribute("account", username);
			response.sendRedirect("/mitakePhoneProject/users.jsp");
		}
		System.out.println(username);
		System.out.println(password);
		System.out.println("成功碼 :" + code);

	}

}
