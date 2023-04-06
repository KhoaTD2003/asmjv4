package com.poly.controller;

import java.io.IOException;
import java.io.Serial;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.controller.constant.SessionAttr;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.VideoServiceImpl;
@WebServlet("/video")
public class VideoController extends HttpServlet{

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	private VideoService videoService = new VideoServiceImpl();
	private HistoryService historyService = new HistoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionParam = req.getParameter("action");
		String href = req.getParameter("id");
		HttpSession session = req.getSession();
		switch (actionParam) {
		case "watch": 
			doGetWatch(session,href,req,resp);
		case "like": 
			doGetLike(session,href,req,resp);
		
		}
		
		}
		
	
	private void doGetWatch(HttpSession session,String href,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video = videoService.findByHref(href);
		req.setAttribute("video", video);
		User curentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if(curentUser != null) {
			History history = historyService.create(curentUser, video);
			req.setAttribute("flagLikedBtn", history.getIsLiked());
		}
		req.getRequestDispatcher("/views/user/video_detail.jsp").forward(req, resp);
	
} 
	private void doGetLike(HttpSession session,String href,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		User curentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		boolean result  = historyService.updateLikeOrUnLike(curentUser, href);
		if(result == true) {
			resp.setStatus(204);
		}else {
			resp.setStatus(400);
		}
	} 
	
}
