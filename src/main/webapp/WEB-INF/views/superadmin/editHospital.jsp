<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%-- <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href='<core:url value="/resources/css/bootstrap.min.css"/>'>
<link rel="stylesheet" href='<core:url value="/resources/css/login.css"/>' >
<link href="<core:url value="/resources/css/animate.css"/>" rel="stylesheet"> 
<!-- jQuery -->
<script src='<core:url value="/resources/js/jquery.js"/>'></script>
 <!-- Bootstrap Core JavaScript -->
<script src='<core:url value="/resources/js/bootstrap.min.js"/>'></script>

<script src="<core:url value="/resources/css/bootstrap.min.css"/>"></script>
<script src='<core:url value="/resources/js/login.js"/>'></script>
 
<script type="text/javascript">

</script>
</head> --%>
<body>

<!-- Fixed navbar -->
        <!-- <nav id="header" class="navbar navbar-fixed-top">
            <div id="header-container" class="container navbar-container">
                <div class="navbar-header">
                    
                    <a id="brand" class="navbar-brand" href="#"><img src="resources/images/hospital-logo.jpg" alt="logo" class="img img-responsive" /></a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li ><a href="home">Home</a></li>
                         <li class="active"><i class="icon-home icon-black"></i><a href="home">SignUp</a></li>
                      
                        <li><a href="getLoginPage" >Login</a></li>
                        <li><a href="about">About</a></li>
                        <li><a href="contact">Contact</a></li>
                         <li><a href="contact"></a></li>
                    </ul>
                </div>/.nav-collapse
            </div>/.container
        </nav>/.navbar
 -->
<div class="container">
     <div class="row">
   <div class="col-md-6 col-md-offset-3">
    <div class="panel panel-login">
     <div class="panel-heading">
      <div class="row">
       <div class="col-xs-6">       
         <label class="active" id="login-form-link">Edit Hospital</label>
       </div>
       
      </div>
      <hr>
     </div>
     <div class="panel-body">
      <div class="row">
       <div class="col-lg-12">
        <form:form id="registration-form" action="./updateHospital"  commandName="hospBean" method="POST" role="form" style="display: block;">
         <div class="form-group">
          <form:input path="hospitalId" type="hidden"  id="hospitalId" tabindex="1" class="form-control" placeholder="hospitalId" value=""></form:input>
         </div>
         <div class="form-group">
          <form:input path="hospitalName" type="text"  id="firstName" tabindex="1" class="form-control" placeholder="HospitalName" value=""></form:input>
         </div>
         <div class="form-group">
          <form:input path="email" type="text"  id="email" tabindex="1" class="form-control" placeholder="Email" value=""></form:input>
         </div>
         <div class="form-group">
          <form:input path="phone" type="text"  id="phoneNumber" tabindex="1" class="form-control" placeholder="PhoneNumber" value=""></form:input>
         </div>
         <div class="form-group">
          <form:input path="address1" type="text"  id="address1" tabindex="1" class="form-control" placeholder="Address1" value=""></form:input>
         </div>
         <div class="form-group">
          <form:input path="address2" type="text"  id="address2" tabindex="1" class="form-control" placeholder="Address2" value=""></form:input>
         </div>
         <div class="form-group">
          <form:input path="city" type="text"  id="city" tabindex="1" class="form-control" placeholder="City" value=""></form:input>
         </div>
         <div class="form-group">
          <form:input path="state" type="text"  id="state" tabindex="1" class="form-control" placeholder="State" value=""></form:input>
         </div>
         <div class="form-group">
          <form:input path="zipCode" type="text"  id="zipCode" tabindex="1" class="form-control" placeholder="ZipCode" value=""></form:input>
         </div>
         <div class="form-group">
          <form:input path="status" type="text"  id="status" tabindex="1" class="form-control" placeholder="Status" value=""></form:input>
         </div>
         <!-- <div class="form-group text-center">
          <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
          <label for="remember"> Remember Me</label>
         </div> -->
         <div class="form-group">
          <div class="row">
           <div class="col-sm-6 col-sm-offset-3">
            <input type="submit"  id="registration-submit" tabindex="4" class="form-control btn btn-registartion" value="Update">
           </div>
          </div>
         </div>
         <!-- <div class="form-group">
          <div class="row">
           <div class="col-sm-6 col-sm-offset-3">
            <input type="submit"  id="registration-cancel" tabindex="4" class="form-control btn btn-login" value="Log In">
           </div>
          </div>
         </div> -->
        
        </form:form>
       </div>
      </div>
     </div>
    </div>
   </div>
  </div>
 </div>
 
        <div class="container">

            <div class="row row-offcanvas row-offcanvas-right">

                <div class="col-xs-12 col-sm-9">
               
                 <hr>
  
   <footer>
                <p>� Company 2014</p>
      </footer>
 </div>
 </div></div>
 
</body>
</html>