<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Table Reservation</title>
    <jsp:include page="/components/allcdns.jsp"/>
</head>
<body class="bg-light">

<jsp:include page="/components/navbar.jsp"/>

<div class="container my-5">

    <div class="text-center mb-4">
        <h1 class="fw-bold">Smart Table Reservation</h1>
        <p class="text-muted">
            Choose your preferred seating and time. Flexible booking options available.
        </p>
    </div>

    <div class="card shadow">
        <div class="card-body p-4">

            <form action="<%=request.getContextPath()%>/BookTable" method="post">

                <!-- Name & Phone -->
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">Customer Name</label>
                        <input type="text" name="name" class="form-control" required>
                    </div>

                    <div class="col-md-6">
                        <label class="form-label">Phone</label>
                        <input type="tel" name="phone" class="form-control" required>
                    </div>
                </div>

                <!-- Persons & Seating Type -->
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">Number of Persons</label>
                        <input type="number" name="persons" class="form-control" min="1" max="50" required>
                    </div>

                    <div class="col-md-6">
                        <label class="form-label">Seating Type</label>
                        <select name="type" id="seatingType" class="form-select" required onchange="updateSlots()">
                            <option value="">Select</option>
                            <option value="STANDARD">Standard Dining</option>
                            <option value="FAMILY">Family</option>
                            <option value="GROUP">Group</option>
                            <option value="HALL">Private Event Hall</option>
                        </select>
                    </div>
                </div>

                <!-- Date -->
                <div class="mb-3">
                    <label class="form-label">Booking Date</label>
                    <input type="date" name="date" class="form-control" required>
                </div>

                <!-- Time Slot -->
                <div class="mb-3">
                    <label class="form-label">Time Slot</label>
                    <select name="timeslot" id="timeslot" class="form-select">
                        <option value="">Select seating type first</option>
                    </select>
                </div>

                <!-- Custom Time Option -->
                <div class="card bg-light p-3 mb-3">
                    <h6 class="fw-bold">Or Choose Custom Time</h6>

                    <div class="row">
                        <div class="col-md-6">
                            <label class="form-label">Start Time</label>
                            <input type="time" name="customStart" class="form-control">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Duration (hours)</label>
                            <select name="duration" class="form-select">
                                <option value="">Select</option>
                                <option value="1">1 Hour</option>
                                <option value="2">2 Hours</option>
                                <option value="3">3 Hours</option>
                                <option value="4">4 Hours</option>
                                <option value="6">6 Hours</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="text-center">
                    <button class="btn btn-warning fw-bold px-5">
                        Reserve Now
                    </button>
                </div>

            </form>

        </div>
    </div>

</div>

<jsp:include page="/components/footer.jsp"/>
<jsp:include page="/components/allscripts.jsp"/>

<!-- Dynamic Slot Script -->
<script>
function updateSlots() {
    let type = document.getElementById("seatingType").value;
    let slot = document.getElementById("timeslot");

    slot.innerHTML = "";

    if(type === "HALL") {
        slot.innerHTML += `<option value="10-2">10 AM - 2 PM</option>`;
        slot.innerHTML += `<option value="2-6">2 PM - 6 PM</option>`;
        slot.innerHTML += `<option value="6-10">6 PM - 10 PM</option>`;
        slot.innerHTML += `<option value="full">Full Day</option>`;
    }
    else {
        slot.innerHTML += `<option value="10-12">10 AM - 12 PM</option>`;
        slot.innerHTML += `<option value="12-2">12 PM - 2 PM</option>`;
        slot.innerHTML += `<option value="2-4">2 PM - 4 PM</option>`;
        slot.innerHTML += `<option value="6-8">6 PM - 8 PM</option>`;
        slot.innerHTML += `<option value="8-10">8 PM - 10 PM</option>`;
    }
}
</script>

</body>
</html>
