<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>
</head>
<body>
<%@page import="all.model.Employee"%>

<%
Employee user = (Employee) session.getAttribute("loggedInUser");

if(user == null){
request.setAttribute("err","Session expired. Please login again.");
request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
return;
}
%>

<!DOCTYPE html>

<html>
<head>

<title>Reset Password</title>

<jsp:include page="/components/allcdns.jsp"/>

</head>

<body class="bg-light">

<jsp:include page="/components/navbar.jsp"/>

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-5">

<div class="card shadow-lg border-0">

<div class="card-header bg-warning text-dark text-center">

<h4 class="fw-bold">Reset Password</h4>

</div>

<div class="card-body p-4">

<form action="<%=request.getContextPath()%>/ResetPassword" method="post">

<div class="mb-3">
<label class="form-label">Current Password</label>
<input type="password"
       name="currentPassword"
       class="form-control"
       required>
</div>

<div class="mb-3">
<label class="form-label">New Password</label>
<input type="password"
       name="newPassword"
       class="form-control"
       required>
</div>

<div class="mb-3">
<label class="form-label">Confirm New Password</label>
<input type="password"
       name="confirmPassword"
       class="form-control"
       required>
</div>

<div class="text-center">

<button class="btn btn-warning fw-bold px-4">

Update Password

</button>

</div>

</form>

</div>

</div>

</div>

</div>

</div>

<jsp:include page="/components/allscripts.jsp"/>

</body>
</html>

</body>
</html>