package com.poly.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.poly.entity.Video;
import com.poly.service.VideoService;
import com.poly.service.impl.VideoServiceImpl;
@WebServlet({"/advideo"})
public class adVideoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
		private VideoService videoService = new VideoServiceImpl();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String action = req.getParameter("action");
			if (action == null) {
				// Lấy danh sách tất cả video
//				List<Video> videos = videoService.findAll();
//				req.setAttribute("videos", videos);
				req.getRequestDispatcher("/views/admin/listvideo.jsp").forward(req, resp);
			} /*
				 * else if (action.equals("create")) { // Hiển thị form tạo mới video
				 * req.getRequestDispatcher("/WEB-INF/views/videos/create.jsp").forward(req,
				 * resp); } else if (action.equals("edit")) { // Lấy thông tin video theo id và
				 * hiển thị form chỉnh sửa Integer id =
				 * Integer.parseInt(req.getParameter("id")); Video video =
				 * videoService.findById(id); req.setAttribute("video", video);
				 * req.getRequestDispatcher("/WEB-INF/views/videos/edit.jsp").forward(req,
				 * resp); } else if (action.equals("delete")) { // Xóa video theo id và chuyển
				 * hướng về trang danh sách video Integer id =
				 * Integer.parseInt(req.getParameter("id")); videoService.delete(id);
				 * resp.sendRedirect(req.getContextPath() + "/videos"); } else if
				 * (action.equals("detail")) { // Lấy thông tin video theo id và hiển thị trang
				 * chi tiết Integer id = Integer.parseInt(req.getParameter("id")); Video video =
				 * videoService.findById(id); req.setAttribute("video", video);
				 * req.getRequestDispatcher("/WEB-INF/views/videos/detail.jsp").forward(req,
				 * resp); }
				 */
		}
		/*
		 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
		 * resp) throws ServletException, IOException { String action =
		 * req.getParameter("action"); if (action.equals("create")) { // Tạo mới video
		 * từ form và chuyển hướng về trang danh sách video String title =
		 * req.getParameter("title"); String href = req.getParameter("href"); String
		 * poster = req.getParameter("poster"); String description =
		 * req.getParameter("description"); Video video = new Video();
		 * video.setTitle(title); video.setHref(href); video.setPoster(poster);
		 * video.setDescriptions(description); videoService.create(video);
		 * resp.sendRedirect(req.getContextPath() + "/videos"); } else if
		 * (action.equals("edit")) { // Chỉnh sửa video từ form và chuyển hướng về trang
		 * danh sách video Integer id = Integer.parseInt(req.getParameter("id")); String
		 * title = req.getParameter("title"); String href = req.getParameter("href");
		 * String poster = req.getParameter("poster"); String description =
		 * req.getParameter("description"); Video video = videoService.findById(id);
		 * video.setTitle(title); video.setHref(href); video.setPoster(poster);
		 * video.setDescriptions(description); videoService.update(video);
		 * resp.sendRedirect(req.getContextPath() + "/videos"); } }
		 */
	}


