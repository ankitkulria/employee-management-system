<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand ms-3" href="<%= request.getContextPath() %>/index.jsp"><img height=60px width=75px  src="<%= request.getContextPath() %>/assets/images/favicon.png"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%= request.getContextPath() %>/index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath() %>/Menu">Menu</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            More
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/pages/contact.jsp">Contact Us</a></li>
            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/pages/about.jsp">About Us</a></li>
            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/pages/bookings.jsp">Bookings</a></li>
          </ul>
        </li>
      </ul>   
    </div>
    <%
    Boolean isLoggedIn=(Boolean)session.getAttribute("isLoggedIn");
    if(isLoggedIn==null|| isLoggedIn==false)
    {
    %>
    <div> <a href="<%= request.getContextPath() %>/pages/login.jsp"><button type="button" class="btn btn-warning">Login</button></a></div>
    <div><a href="<%= request.getContextPath() %>/pages/register.jsp"><button type="button" class="btn btn-info ms-2">Register</button></a></div>
    <%
    }
    else
    {
    %>
    <div>
    		<a href="<%= request.getContextPath() %>/pages/admin/dashboard.jsp">
    			<button type="button" class="btn btn-danger ms-2"><i class="fa-solid fa-user"></i></button>
    		</a>
    	</div>
    <div>
    		<a href="<%= request.getContextPath() %>/Logout">
    			<button type="button" class="btn btn-info ms-2">Log Out</button>
    		</a>
    	</div>
    <%}%>
  </div>
</nav>