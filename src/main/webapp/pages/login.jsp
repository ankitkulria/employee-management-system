<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
	<jsp:include page="/components/allcdns.jsp"/>
</head>

<body class="bg-light">
<jsp:include page="/components/navbar.jsp"/>
<div class="container mt-5 mb-5">
	
	<jsp:include page="/components/alert.jsp"/>
	
    <div class="row justify-content-center align-items-center" style="min-height: 70vh;">
        <div class="col-md-6 col-lg-5">

            <div class="card shadow-lg p-4">
                <h3 class="text-center text-warning fw-bold mb-4">
                    Employee Login
                </h3>

                <form action="<%= request.getContextPath() %>/EmployeeLogin" method="post">

                    <!-- Email -->
                    <div class="mb-3">
                        <label class="form-label">Email Address</label>
                        <input type="email"
                               name="email"
                               class="form-control"
                               placeholder="Enter your email"
                               required>
                    </div>

                    <!-- Password -->
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input type="password"
                               name="password"
                               class="form-control"
                               placeholder="Enter your password"
                               required>
                    </div>

                    <!-- Remember Me -->
                    <div class="d-flex justify-content-between align-items-center mb-4">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="rememberMe">
                            <label class="form-check-label" for="rememberMe">
                                Remember me
                            </label>
                        </div>
                        <a href="#" class="text-decoration-none text-warning fw-semibold">
                            Forgot password?
                        </a>
                    </div>

                    <!-- Login Button -->
                    <div class="d-grid">
                        <button type="submit" class="btn btn-warning fw-bold">
                            Login
                        </button>
                    </div>

                </form>

                <hr>

                <p class="text-center mb-0">
                    New employee?
                    <a href="<%= request.getContextPath() %>/pages/register.jsp"
                       class="text-warning fw-semibold text-decoration-none">
                        Register here
                    </a>
                </p>
            </div>

        </div>
    </div>
</div>
<jsp:include page="/components/allscripts.jsp"/>
</body>
</html>
