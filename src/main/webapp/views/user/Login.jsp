<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/common/taglib.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
       <%@ include file="/common/head.jsp" %>

</head>

<body>
     <%@ include file="/common/header.jsp" %>
     
      <div class="container-fluid tm-mt-60"></div>
        <div class="row tm-mb-50">
            <div class="col-lg-12 col-12 mb-5">
              <center>  <h2 class="tm-text-primary mb-5"> Đăng Nhập</h2></center>
                <form id="login-form" action="Login" method="POST" class="tm-contact-form mx-auto">
                    <div class="form-group">
                        <input type="text" name="username" class="form-control rounded-0" placeholder="Name" required />
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control rounded-0" placeholder="PAss" required />
                    </div>
                  

                    <div class="form-group tm-text-right">
                        <button type="submit" class="btn btn-primary">Send</button>
                    </div>
                </form>                
            </div>
           </div> 
       <%@ include file="/common/footer.jsp" %>

</body>
</html>