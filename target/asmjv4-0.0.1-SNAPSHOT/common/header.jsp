<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Page Loader -->
    <div id="loader-wrapper">
        <div id="loader"></div>

        <div class="loader-section section-left"></div>
        <div class="loader-section section-right"></div>

    </div>
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="http://localhost:8080/asmjv4/index">
                <i class="fas fa-film mr-2"></i>
                Catalog-Z
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
            <c:choose>
            	<c:when test ="${not empty sessionScope.currentUser}">
            	  <li class="nav-item">
                    <a class="nav-link nav-link-1 active" aria-current="page" href="index.html">Hello,${sessionScope.currentUser.username}</a>
                </li>
                  <li class="nav-item">
                    <a class="nav-link nav-link-1 active" aria-current="page" href="index.html">Favourite</a>
                </li>
                  <li class="nav-item">
                    <a class="nav-link nav-link-1 active" aria-current="page" href="index.html">History</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link nav-link-1 active" aria-current="page" href="logout">Logout</a>
                </li>
            	</c:when>
            <c:otherwise> 
                <li class="nav-item">
                    <a class="nav-link nav-link-2" href="Login">Đăng Nhập</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link-3" href="sigup">Đăng Ký</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link nav-link-4" href="contact.html">Forgot password</a>
                </li>
            </c:otherwise>
            </c:choose>
            
             </ul> 
               
            </div>
        </div>
    </nav>

    <div class="tm-hero d-flex justify-content-center align-items-center" data-parallax="scroll" data-image-src="<c:url value='/templates/User/img/hero.jpg'/>">
        <form class="d-flex tm-search-form">
            <input class="form-control tm-search-input" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success tm-search-btn" type="submit">
                <i class="fas fa-search"></i>
            </button>
        </form>
    </div>