<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Danh sách sản phẩm</title>
	<!-- Thêm các thư viện CSS cho Bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Danh sách sản phẩm</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Tên sản phẩm</th>
					<th>Href  </th>
					<th>Poster</th>
					<th>views</th>
					<th>shares</th>
					<th>Mô tả</th>
					<th>isActive</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="videos" items="${videos}">
					<tr>
						<td>${videos.id}</td>
						<td>${videos.title}</td>
						<td>${videos.href}</td>
						<td>${videos.poster}</td>
						<td>${videos.views}</td>
						<td>${videos.shares}</td>
						<td>${videos.descriptions}</td>
						<td>${videos.isActive ? "Hoat dong" : "Khong hoat dong"}</td>
						
						<td>
							<a href="?mode=edit&id=${videos.id}"><button type="button" class="btn btn-info"> Sửa</button></a>
							<a href="?mode=delete&href=${videos.href}"><button type="button" class="btn btn-danger"> Xóa</button></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="?mode=create"><button type="button" class="btn btn-success">Thêm sản phẩm mới</button></a>
	</div>
</body>
</html>
