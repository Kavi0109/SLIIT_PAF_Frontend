<%@page import="com.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.min.js"></script>
<script src="Components/users.js"></script>
</head>
<body>
<!--  <section class="vh-100 bg-image"style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
 
<div class="container"><div class="row"><div class="col-6">
<div class="card text-black" style="border-radius: 25px;">
<div class="card-body p-md-5">

	<h1><center>User Management </center></h1>

	<form id="formItem" name="formItem" class="mx-1 mx-md-4">
 		Full Name:
 		<input id="name" name="name" type="text" class="form-control form-control-sm">
 		<br> 
 		Email Address:
		<input id="email" name="email" type="text" class="form-control form-control-sm">
 		<br> 
 		Password:
 		<input id="pass" name="pass" type="text" class="form-control form-control-sm">
 		<br> 
 		Mobile:
		<input id="mobile" name="mobile" type="text" class="form-control form-control-sm">
 		<br>
 		User Type:
		<input id="type" name="type" type="text" class="form-control form-control-sm">
 		<br>
 		
 		<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
 		<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
	</form>
	<br/>
</div>	


</div>-->
	
<!-- </div> </div> </div> -->


<div>

<section class="vh-100 bg-image"
  style="background-color: #EFD3E4;
          background-image: url(https://mdbootstrap.com/img/Photos/new-templates/search-box/img1.jpg);"><br><br>
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
              <h2 class="text-center mb-5">Registration Form</h2>

              <form id="formItem" name="formItem" class="mx-1 mx-md-4">

                <div class="form-outline mb-4">
                  <input id="name" name="name" type="text" class="form-control form-control-lg" placeholder="Full Name" />
                </div>

                <div class="form-outline mb-4">
                  <input id="email" name="email" type="text" class="form-control form-control-lg" placeholder="Email Address" />
                </div>

                <div class="form-outline mb-4">
                  <input id="pass" name="pass" type="password" class="form-control form-control-lg" placeholder="Password"/>
                </div>

                <div class="form-outline mb-4">
                  <input id="mobile" name="mobile" type="text" class="form-control form-control-lg" placeholder="Contact Number" />
                </div>
                
                <div class="form-outline mb-4">
                  <input id="type" name="type" type="text" class="form-control form-control-lg" placeholder="User Type" />
                </div>


                <div class="d-flex justify-content-center">
                  
                    <input id="btnSave" name="btnSave" type="button" value="Add User" class="btn btn-secondary btn-rounded btn-block">
 		<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
                </div>
              </form>
              

            </div>
          </div><br><br>
        </div><br><br>
      </div><br><br>
    </div><br><br>
    <br><br>
  </div>
  

</section>

<center>
  <div id="alertSuccess" class="alert alert-primary"></div>
	<div id="alertError" class="alert alert-danger"></div>

	<br>
	<div id="divItemsGrid">
 		<%
 			User userObj = new User();
 			out.print(userObj.readUsers());
 		%>
	</div>
	</center>

</div><br><br><br><br>
</section>
</body>
</html>