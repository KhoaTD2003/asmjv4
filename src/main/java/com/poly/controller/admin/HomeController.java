package com.poly.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttr;
import com.poly.dto.VideoLikedInfo;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.StatsService;
import com.poly.service.VideoService;
import com.poly.service.impl.StatsServiceImpl;
import com.poly.service.impl.VideoServiceImpl;

@WebServlet(name = "qly-sp" ,value =
		{"/qly-sp/qlvideo","/qly-sp/videoupdate","/qly-sp/addvideo"})
public class HomeController extends HttpServlet{
private VideoService videoService = new VideoServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StatsService statsService = new StatsServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();
	User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
	if(currentUser != null && currentUser.getIsAdmin() ==Boolean.TRUE & uri.contains("qlvideo") ) {
		List<VideoLikedInfo> videos = statsService.findVideoLikedInfo();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/qlvideo.jsp").forward(req, resp);	

	}else if ( currentUser != null && currentUser.getIsAdmin() ==Boolean.TRUE & uri.contains("addvideo")){
		req.getRequestDispatcher("/views/admin/addVideo.jsp").forward(req, resp);
	}else if(currentUser != null && currentUser.getIsAdmin() ==Boolean.TRUE & uri.contains("update")) {
		req.getRequestDispatcher("/views/admin/update.jsp").forward(req, resp);
		
	}/*else {
		resp.getWriter().write("chưa đăng nhập");
	}*/
	}
	
	/*
	 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { // Lấy thông tin từ form post
	 * String title = request.getParameter("title"); String url =
	 * request.getParameter("url"); String description =
	 * request.getParameter("description");
	 * 
	 * // Tạo đối tượng Video từ thông tin trên form Video video = new Video();
	 * video.setTitle(title); video.setHref(url); video.setDescription(description);
	 * 
	 * // Thêm đối tượng Video vào database videoService.create(video);
	 * 
	 * // Redirect về trang hiển thị danh sách video
	 * response.sendRedirect(request.getContextPath() + "/video"); }
	 */
	 
}
