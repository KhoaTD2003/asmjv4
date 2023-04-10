<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Thêm sản phẩm mới</title>
	<!-- Thêm các thư viện CSS cho Bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Thêm sản phẩm mới</h2>
		<form action="?mode=create" method="post">
			<div class="form-group">
				<label for="title">Tên sản phẩm:</label>
				<input type="text" class="form-control" id="title" name="title" required placeholder ="Tên Sản Phẩm" >
			</div>
			<div class="form-group">
				<label for="href">Href:</label>
				<input type="text" class="form-control" id="href" name="href" required>
			</div>
			<div class="form-group">
				<label for="poster">Poster:</label>
				<input type="text" class="form-control" id="poster" name="poster" required>
			</div>
			<div class="form-group">
				<label for="views">Số lần xem:</label>
				<input type="number" class="form-control" id="views" name="views" value="0">
			</div>
			<div class="form-group">
				<label for="shares">Số lần chia sẻ:</label>
				<input type="number" class="form-control" id="shares" name="shares" value = "0">
			</div>
			<div class="form-group">
				<label for="description">Mô tả:</label>
				<textarea class="form-control" id="description" name="description" rows="5"></textarea>
			</div>
			<div class="form-group">
				<label for="isActive">Trạng thái hoạt động:</label>
				<select class="form-control" id="isActive" name="isActive" required>
					<option value="true">Hoạt động</option>
					<option value="false">Không hoạt động</option>
				</select>
			</div>
			<button type="submit" class="btn btn-success">Thêm sản phẩm</button>
			<a href="all"><button type="button" class="btn btn-danger">Hủy</button></a>
		</form>
	</div>
</body>
</html>
