<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa sản phẩm</title>
    <!-- Thêm các thư viện CSS cho Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h2>Sửa sản phẩm</h2>
       <form action="?mode=edit&id=${videos.id}" method="post">
         <input type="hidden" name="id" value="${videos.id}" />
         <div class="form-group">
           <label for="title">Tên sản phẩm:</label>
           <input type="text" class="form-control" id="title" name="title" value="${videos.title}">
         </div>
         <div class="form-group">
           <label for="href">Href:</label>
           <input type="text" class="form-control" id="href" name="href" value="${videos.href}">
         </div>
         <div class="form-group">
           <label for="poster">Poster:</label>
           <input type="text" class="form-control" id="poster" name="poster" value="${videos.poster}">
         </div>
         <div class="form-group">
           <label for="descriptions">Mô tả:</label>
           <input type="text" class="form-control" id="descriptions" name="description" value="${videos.descriptions}">
         </div>
         <button type="submit" class="btn btn-primary">Lưu</button>
       </form>
    </div>
</body>
</html>
