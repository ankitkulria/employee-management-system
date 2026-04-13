<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Us</title>
    <jsp:include page="/components/allcdns.jsp"/>
</head>
<body class="bg-light">

<jsp:include page="/components/navbar.jsp"/>

<!-- Header -->
<div class="container-fluid bg-warning py-4 text-center">
    <h1 class="fw-bold">Contact Us</h1>
    <p class="mb-0">We’d love to hear from you</p>
</div>

<div class="container my-5">
    <div class="row g-4">

        <!-- Contact Form -->
        <div class="col-lg-7">
            <div class="card shadow-sm">
                <div class="card-body p-4">
                    <h4 class="mb-4">Send Us a Message</h4>

                    <form action="<%=request.getContextPath()%>/SendMessage" method="post">

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label class="form-label">Name</label>
                                <input type="text" name="name" class="form-control" required>
                            </div>

                            <div class="col-md-6">
                                <label class="form-label">Email</label>
                                <input type="email" name="email" class="form-control" required>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Subject</label>
                            <input type="text" name="subject" class="form-control" required>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">Message</label>
                            <textarea name="message" rows="4" class="form-control" required></textarea>
                        </div>

                        <button type="submit" class="btn btn-warning fw-bold px-4">
                            Send Message
                        </button>

                    </form>
                </div>
            </div>
        </div>

        <!-- Contact Info -->
        <div class="col-lg-5">
            <div class="card shadow-sm mb-4">
                <div class="card-body p-4">
                    <h4 class="mb-3">Restaurant Info</h4>

                    <p class="mb-2">📍 <strong>Address:</strong> Sirsa, Haryana, India</p>
                    <p class="mb-2">📞 <strong>Phone:</strong> +91 98765 43210</p>
                    <p class="mb-2">✉️ <strong>Email:</strong> restro@email.com</p>
                    <p class="mb-0">⏰ <strong>Timings:</strong> 10:00 AM – 11:00 PM</p>
                </div>
            </div>

            <!-- Map -->
            <div class="card shadow-sm">
                <iframe
                    src="https://maps.google.com/maps?q=Sirsa%20Haryana&t=&z=13&ie=UTF8&iwloc=&output=embed"
                    width="100%" height="220" style="border:0;"
                    loading="lazy">
                </iframe>
            </div>
        </div>

    </div>
</div>

<jsp:include page="/components/footer.jsp"/>
<jsp:include page="/components/allscripts.jsp"/>

</body>
</html>
