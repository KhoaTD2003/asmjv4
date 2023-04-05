<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> ${video.title} </title>
<%@ include file ="/common/head.jsp" %>
 
</head>
<body>
      <%@ include file="/common/header.jsp" %>

         <div class="container-fluid tm-container-content tm-mt-60">
        <div class="row mb-4">
            <h2 class="col-12 tm-text-primary">${video.title}</h2>
        </div>
        <div class="row tm-mb-90">
            <div class="col-xl-8 col-lg-7 col-md-6 col-sm-12">
                  <iframe id="tm-video" src = "http://www.youtube.com/embed/${video.href}" style="height: 500px"></iframe>

            </div>
            <div class="col-xl-4 col-lg-5 col-md-6 col-sm-12">
                <div class="tm-bg-gray tm-video-details">
                   <c:if test="${not empty sessionScope.currentUser}">
                    <div class="text-center mb-5">
                       <a href="<c:url value ='/video?action=like&id=${video.href}'/>" class="btn btn-primary tm-btn-big">
                        <c:choose>
                        <c:when test="${flagLikedBtn == true }">
                        	Unlike
                        </c:when>
                        <c:otherwise>Like</c:otherwise>
                        </c:choose>
                        </a>
                    </div>

                      <div class="text-center mb-5">
                        <a href="#" class="btn btn-primary tm-btn-big">Share</a>
                    </div>
                    </c:if>
                    <div class="mb-4">
                        <h3 class="tm-text-gray-dark mb-3">Decription</h3>
                        <p> ${video.descriptions}</p>
                    </div>

                </div>
            </div>
        </div>

            </div>
        
       <%@ include file="/common/footer.jsp" %>
   
</body>
</html>