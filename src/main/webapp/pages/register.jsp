<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register</title>
<jsp:include page="/components/allcdns.jsp" />
</head>
<body>
	<jsp:include page="/components/navbar.jsp" />
	<jsp:include page="/components/alert.jsp" />
	<div class="container mt-5 mb-5">
		<div class="row justify-content-center">
			<div class="col-lg-9">

				<div class="card shadow p-4">
					<h3 class="text-center mb-4 text-warning fw-bold">Employee
						Registration</h3>

					<form action="<%=request.getContextPath()%>/EmployeeRegister"
						method="post">

						<!-- Row 1 -->
						<div class="row mb-3">
							<div class="col-md-6">
								<label class="form-label">Full Name</label> <input type="text"
									name="name" class="form-control" placeholder="Enter full name"
									required>
							</div>

							<div class="col-md-6">
								<label class="form-label">Role</label> <select name="role"
									class="form-select" required>
									<option value="">Select role</option>
									<option value="Manager">Manager</option>
									<option value="Head Chef">Head Chef</option>
									<option value="Chef">Chef</option>
									<option value="Kitchen Staff">Kitchen Staff</option>
									<option value="Waiter">Server</option>
									<option value="Cashier">Cashier</option>
									<option value="Receptionist">Receptionist</option>
									<option value="Delivery Staff">Delivery Staff</option>
									<option value="Cleaner">Housekeeping</option>
								</select>

							</div>
						</div>

						<!-- Row 2 -->
						<div class="row mb-3">
							<div class="col-md-6">
								<label class="form-label">Phone</label> <input type="tel"
									name="phone" class="form-control"
									placeholder="Enter phone number" required>
							</div>

							<div class="col-md-6">
								<label class="form-label">Salary</label> <input type="number"
									step="0.01" name="salary" class="form-control"
									placeholder="Enter salary" required>
							</div>
						</div>

						<!-- Row 3 -->
						<div class="row mb-3">
							<div class="col-md-6">
								<label class="form-label">Gender</label> <select name="gender"
									class="form-select" required>
									<option value="">Select gender</option>
									<option>Male</option>
									<option>Female</option>
									<option>Other</option>
								</select>
							</div>

							<div class="col-md-6">
								<label class="form-label">Marital Status</label>
								<div class="d-flex gap-4 mt-2">
									<div class="form-check">
										<input class="form-check-input" type="radio" name="isMarried"
											value="true"> <label class="form-check-label">Married</label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="isMarried"
											value="false" checked> <label
											class="form-check-label">Unmarried</label>
									</div>
								</div>
							</div>
						</div>

						<!-- Row 4 -->
						<div class="row mb-3">
							<div class="col-md-6">
								<label class="form-label">Email</label> <input type="email"
									name="email" class="form-control" placeholder="Enter email"
									required>
							</div>

							<div class="col-md-6">
								<label class="form-label">Password</label> <input
									type="password" name="password" class="form-control"
									placeholder="Create password" required>
							</div>
						</div>

						<!-- Row 5 -->
						<div class="row mb-4">
							<div class="col-md-6">
								<label class="form-label">Joined Date</label> <input type="date"
									name="joineddate" class="form-control" required>
							</div>
						</div>

						<!-- Button -->
						<div class="text-center">
							<button type="submit" class="btn btn-warning px-5 fw-bold">
								Register Employee</button>
						</div>

					</form>
				</div>

			</div>
		</div>
	</div>
	<jsp:include page="/components/allscripts.jsp" />
</body>
</html>