<%@page import="all.model.Employee"%>
<%@page import="java.util.List"%>
<%
Employee emp = (Employee) session.getAttribute("loggedInUser");
if (emp == null) {
	request.setAttribute("err", "Login to access  Dashboard");
	request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
	return;
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DashBoard</title>
<jsp:include page="/components/allcdns.jsp" />
<link rel="stylesheet"
	href="https://cdn.datatables.net/2.3.7/css/dataTables.bootstrap5.css">
	
	
</head>
<body>
	<jsp:include page="/components/navbar.jsp" />
	<h1>
		Hello
		<%=emp.getName()%></h1>
	<%
	boolean isAdmin = emp.getEmail().equalsIgnoreCase("kulriaankit25@gmail.com");
	%>
	
	<%
if (isAdmin) {
%>

<h3 style="color: green;">Admin Panel</h3>
<%
String msg = (String) session.getAttribute("msg");
String err = (String) session.getAttribute("err");

if(msg != null){
%>

<div id="alertBox" class="alert alert-success text-center">
<%=msg%>
</div>

<%
session.removeAttribute("msg");
}

if(err != null){
%>

<div id="alertBox" class="alert alert-danger text-center">
<%=err%>
</div>

<%
session.removeAttribute("err");
}
%>

<table id="employee_table" class="table table-striped">

<thead class="table-dark">

<tr>
<th>ID</th>
<th>Name</th>
<th>Role</th>
<th>Phone</th>
<th>Email</th>
<th>Gender</th>
<th>Married</th>
<th>Salary</th>
<th>Joined Date</th>
<th>Actions</th>
</tr>

</thead>

<tbody>

<%
List<Employee> list = (List<Employee>) request.getAttribute("employeeList");

if(list != null){
    for(Employee e : list){
%>

<tr>
<td><%=e.getId()%></td>
<td><%=e.getName()%></td>
<td><%=e.getRole()%></td>
<td><%=e.getPhone()%></td>
<td><%=e.getEmail()%></td>
<td><%=e.getGender()%></td>
<td><%=e.getMarried()%></td>
<td><%=e.getSalary()%></td>
<td><%=e.getJoineddate()%></td>
<td>
<a href="EditEmployee?id=<%=e.getId()%>" class="btn btn-sm btn-warning">Edit</a>

<a href="DeleteEmployee?id=<%=e.getId()%>"
   class="btn btn-sm btn-danger"
   onclick="return confirm('Delete this employee?')">
Delete
</a>
</td>
</tr>

<%
    }
}
%>

</tbody>

</table>

<%
} else {
%>
<div class="container d-flex flex-column justify-content-center align-items-center" style="min-height:70vh;">

<h3 class="mb-4 text-primary fw-bold">Employee Panel</h3>

<div class="card shadow-lg border-0 text-center" style="width:380px;border-radius:18px;overflow:hidden;">

<div class="card-header text-white"
     style="background:linear-gradient(135deg,#41295a,#2F0743);">

<div class="d-flex align-items-center justify-content-center">

<img src="<%=request.getContextPath()%>/assets/images/favicon.png"
  style="width:38px;height:38px;border-radius:6px;margin-right:10px;">

<h5 class="mb-0 fw-bold">FlavorNest</h5>

</div>



</div>

<div class="card-body">

<i class="fa-solid fa-user-circle fa-4x text-secondary mb-3"></i>

<h4 class="fw-bold mb-1"><%=emp.getName()%></h4>
<p class="text-muted mb-3"><%=emp.getRole()%></p>

<hr>

<p><strong>ID:<%=emp.getId()%></strong></p>
<p><strong>Email:<%=emp.getEmail()%></strong></p>
<p><strong>Gender:<%=emp.getGender()%></strong></p>


</div>

</div>

<button class="btn btn-dark mt-4"
     data-bs-toggle="modal"
     data-bs-target="#employeeDetailsModal">

View Full Details

</button>

<div class="mt-3">

<a href="<%=request.getContextPath()%>/pages/employee/reset_password.jsp"
   class="btn btn-warning fw-bold">

Reset Password

</a>

</div>

</div>

<!-- Modal -->

<div class="modal fade" id="employeeDetailsModal" tabindex="-1">

<div class="modal-dialog modal-dialog-centered">

<div class="modal-content">

<div class="modal-header bg-dark text-white">

<h5 class="modal-title">FlavorNest Employee Details</h5>

<button type="button"
     class="btn-close btn-close-white"
     data-bs-dismiss="modal"> </button>

</div>

<div class="modal-body text-center">

<p><strong>ID :</strong> <%=emp.getId()%></p>
<p><strong>Name :</strong> <%=emp.getName()%></p>
<p><strong>Email :</strong> <%=emp.getEmail()%></p>
<p><strong>Phone :</strong> <%=emp.getPhone()%></p>
<p><strong>Gender :</strong> <%=emp.getGender()%></p>
<p><strong>Married :</strong> <%=emp.getMarried()%></p>
<p><strong>Salary :</strong> ₹ <%=emp.getSalary()%></p>
<p><strong>Joined Date :</strong> <%=emp.getJoineddate()%></p>

</div>

<div class="modal-footer justify-content-center">

<button class="btn btn-primary"
     data-bs-dismiss="modal">
Close </button>

</div>

</div>

</div>

</div>

<!-- Employee content will come here later (ID Card / Profile) -->

<%
}
%>
<div class="modal fade" id="employeeDetailsModal" tabindex="-1">

<div class="modal-dialog modal-dialog-centered">

<div class="modal-content">

<div class="modal-header bg-dark text-white">
<h5 class="modal-title">FlavorNest Employee Details</h5>
<button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
</div>

<div class="modal-body">

<p><strong>ID :</strong> <%=emp.getId()%></p>
<p><strong>Name :</strong> <%=emp.getName()%></p>
<p><strong>Email :</strong> <%=emp.getEmail()%></p>
<p><strong>Phone :</strong> <%=emp.getPhone()%></p>
<p><strong>Gender :</strong> <%=emp.getGender()%></p>
<p><strong>Married :</strong> <%=emp.getMarried()%></p>
<p><strong>Salary :</strong> ₹ <%=emp.getSalary()%></p>
<p><strong>Joined Date :</strong> <%=emp.getJoineddate()%></p>

</div>

<div class="modal-footer">
<button class="btn btn-primary" data-bs-dismiss="modal">Close</button>
</div>

</div>

</div>

</div>
	<jsp:include page="/components/footer.jsp" />
	<jsp:include page="/components/allscripts.jsp" />
	<script src="https://cdn.datatables.net/2.3.7/js/dataTables.js"></script>
	<script
		src="https://cdn.datatables.net/2.3.7/js/dataTables.bootstrap5.js"></script>
	<script type="text/javascript">
		new DataTable('#employee_table');
	</script>
	<script>

setTimeout(function(){

var alert = document.getElementById("alertBox");

if(alert){
alert.style.transition = "opacity 0.5s";
alert.style.opacity = "0";

setTimeout(function(){
alert.remove();
},500);

}

},3000);

</script>
</body>
</html>