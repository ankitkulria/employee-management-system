<%@page import="all.model.Employee"%>

<%
Employee loggedUser = (Employee) session.getAttribute("loggedInUser");

if(loggedUser == null){
    request.setAttribute("err","Session expired. Please login again.");
    request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
    return;
}
%>
<%@page import="all.model.Employee"%>

<%
Employee emp = (Employee) request.getAttribute("employee");
%>

<!DOCTYPE html>

<html>
<head>

<title>Edit Employee</title>

<jsp:include page="/components/allcdns.jsp"/>

</head>

<body class="bg-light">

<jsp:include page="/components/navbar.jsp"/>

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-7">

<div class="card shadow-lg border-0">

<div class="card-header bg-warning text-dark text-center">

<h4 class="fw-bold">FlavorNest-Edit Employee</h4>

</div>

<div class="card-body p-4">

<form action="<%=request.getContextPath()%>/UpdateEmployee" method="post">

<!-- ID -->

<div class="mb-3">
<label class="form-label">Employee ID</label>
<input type="text"
       class="form-control"
       value="<%=emp.getId()%>"
       disabled>
<input type="hidden"
       name="id"
       value="<%=emp.getId()%>">
</div>

<!-- Name -->

<div class="mb-3">
<label class="form-label">Name</label>
<input type="text"
       name="name"
       class="form-control"
       value="<%=emp.getName()%>">
</div>

<!-- Email -->

<div class="mb-3">
<label class="form-label">Email</label>
<input type="email"
       class="form-control"
       value="<%=emp.getEmail()%>"
       disabled>
</div>

<!-- Phone -->

<div class="mb-3">
<label class="form-label">Phone</label>
<input type="text"
       name="phone"
       class="form-control"
       value="<%=emp.getPhone()%>">
</div>

<!-- Role -->

<div class="mb-3">
<label class="form-label">Role</label>
<input type="text"
       name="role"
       class="form-control"
       value="<%=emp.getRole()%>">
</div>

<!-- Gender -->

<div class="mb-3">
<label class="form-label">Gender</label>

<select name="gender" class="form-control">

<option value="Male"
<%= emp.getGender().equals("Male") ? "selected" : "" %>>
Male
</option>

<option value="Female"
<%= emp.getGender().equals("Female") ? "selected" : "" %>>
Female
</option>

</select>

</div>

<!-- Married -->

<div class="mb-3">
<label class="form-label">Married</label>

<select name="married" class="form-control">

<option value="Yes"
<%= emp.getMarried().equals("true") ? "selected" : "" %>>
Yes
</option>

<option value="No"
<%= emp.getMarried().equals("false") ? "selected" : "" %>>
No
</option>

</select>

</div>

<!-- Salary -->

<div class="mb-3">
<label class="form-label">Salary</label>
<input type="number"
       name="salary"
       class="form-control"
       value="<%=emp.getSalary()%>">
</div>

<!-- Joined Date -->

<div class="mb-3">
<label class="form-label">Joined Date</label>
<input type="text"
       class="form-control"
       value="<%=emp.getJoineddate()%>"
       disabled>
</div>

<div class="text-center">

<button type="submit"
     class="btn btn-warning fw-bold px-4">

Update Employee

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
