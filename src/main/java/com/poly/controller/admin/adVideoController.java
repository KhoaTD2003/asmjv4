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

@WebServlet(name = "video", value =
        {"/video/all",})
public class adVideoController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private VideoService videoService = new VideoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("mode");
        if (action == null) {
            // Lấy danh sách tất cả video
            List<Video> videos = videoService.findAll();
            req.setAttribute("videos", videos);
            req.getRequestDispatcher("/views/admin/listvideo.jsp").forward(req, resp);

        } else if (action.equals("create")) { // Hiển thị form tạo mới video
            req.getRequestDispatcher("/views/admin/addVideo.jsp").forward(req, resp);

        }else if (action.equals("edit")) {
            String idStr = req.getParameter("id");
            if (idStr == null || idStr.trim().isEmpty()) {
                req.setAttribute("errorMessage", "ID không hợp lệ");
                req.getRequestDispatcher("/views/admin/404.jsp").forward(req, resp);
            } else {
                try {
                    int id = Integer.parseInt(idStr);
                    Video video = videoService.findById(id);
                    if (video == null) {
                        req.setAttribute("errorMessage", "Không tìm thấy video với ID " + id);
                        req.getRequestDispatcher("/views/admin/404.jsp").forward(req, resp);
                    } else {
                        req.setAttribute("videos", video); // sử dụng "videos" thay vì "video"
                        req.getRequestDispatcher("/views/admin/update.jsp").forward(req, resp);
                    }
                } catch (NumberFormatException e) {
                    req.setAttribute("errorMessage", "ID không hợp lệ");
                    req.getRequestDispatcher("/views/admin/404.jsp").forward(req, resp);
                }
            }
        }
   /* /*/
        if (action == null || !action.equals("delete")) {

           return; // handle other actions or default action
        } else {
            String href = req.getParameter("href");
            Video deletedVideo = videoService.delete(href);
            if (deletedVideo == null) {
                // handle video not found
            } else {
                resp.sendRedirect(req.getContextPath() + "/video/all");
            }
        }
        if
        (action.equals("detail")) { // Lấy thông tin video theo id và hiển thị tran chi tiết
            Integer id = Integer.parseInt(req.getParameter("id"));
            Video video = videoService.findById(id);
            req.setAttribute("videos", video);
            req.getRequestDispatcher("/views/videos/detail.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("mode");
        if (action.equals("create")) { // Tạo mới video
            //từ form và chuyển hướng về trang danh sách video
            String title = req.getParameter("title");
            String href = req.getParameter("href");
            String poster = req.getParameter("poster");
            String description = req.getParameter("description");
            Video video = new Video();
            video.setTitle(title);
            video.setHref(href);
            video.setPoster(poster);
            video.setDescriptions(description);
            videoService.create(video);
            resp.sendRedirect(req.getContextPath() + "/video/all");
        } else if (action.equals("edit")) {
            // Chỉnh sửa video từ form và chuyển hướng về trangdanh sách video
            Integer id = Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");
            String href = req.getParameter("href");
            String poster = req.getParameter("poster");
            String description = req.getParameter("description");
            Video video = videoService.findById(id);
            video.setTitle(title);
            video.setHref(href);
            video.setPoster(poster);
            video.setDescriptions(description);
            videoService.update(video);
            resp.sendRedirect(req.getContextPath() + "/video/all");
    }
        else{
            if (action == null || !action.equals("delete")) {
                // handle other actions or default action
            } else {
                String href = req.getParameter("href");
                Video deletedVideo = videoService.delete(href);
                if (deletedVideo == null) {
                    // handle video not found
                } else {
                    resp.sendRedirect(req.getContextPath() + "/listvideo");
                }
            }
        }}
    }



