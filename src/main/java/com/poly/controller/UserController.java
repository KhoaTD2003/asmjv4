package com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.controller.constant.SessionAttr;
import com.poly.entity.User;
import com.poly.service.UserService;
import com.poly.service.impl.UserServiceImpl;
@WebServlet({"/Login","/sigup","/logout"})
public class UserController extends HttpServlet {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/Login": {
			doGetLogin(req, resp);	
			break;
		}
		case "/sigup":{
			doGetSigup(req,resp);
			break;
		}
		case "/logout":{
			doGetLogout(session, req,resp);
			break;
		}
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/Login": {
			doPostLogin(session,req, resp);	
			break;
		}
		case "/sigup": {
			doPostSigup(session,req, resp);	
			break;
		}
		}
	}
	
	protected void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/user/Login.jsp").forward(req, resp);
		}

	protected void doGetSigup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/user/sigup.jsp").forward(req, resp);
		}
	private void doGetLogout(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session.removeAttribute(SessionAttr.CURRENT_USER);
		resp.sendRedirect("index");
	}
	
	protected void doPostLogin(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username = req.getParameter("username"); 
	String password = req.getParameter("password");

		User user = userService.login(username, password);
		
		if(user != null) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			resp.sendRedirect("index");
		}else {
			resp.sendRedirect("Login");
		}
}
	protected void doPostSigup(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username"); 
		String password = req.getParameter("password");
		String email = req.getParameter("email");

			User user = userService.create(username, password,email);
			
			if(user != null) {
				session.setAttribute(SessionAttr.CURRENT_USER, user);
				resp.sendRedirect("index");
			}else {
				resp.sendRedirect("sigup");
			}
	}
}
