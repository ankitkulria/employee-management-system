<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>About Us</title>
    <jsp:include page="/components/allcdns.jsp"/>
</head>
<body class="bg-light">

<jsp:include page="/components/navbar.jsp"/>

<!-- Hero Section -->
<div class="container-fluid bg-warning text-dark py-5 text-center">
    <h1 class="display-5 fw-bold">More Than Food — We Serve Happiness</h1>
    <p class="lead mb-0">
        Where every meal becomes a memory and every visit feels like home.
    </p>
</div>

<!-- About Section -->
<div class="container my-5">
    <div class="row align-items-center">

        <!-- Image Carousel Section -->
        <div class="col-lg-6 mb-4">

            <div id="aboutCarousel"
                 class="carousel slide carousel-fade shadow rounded"
                 data-bs-ride="carousel"
                 data-bs-interval="3000">

                <div class="carousel-inner">

                    <div class="carousel-item active">
                        <img src="<%=request.getContextPath()%>/assets/images/exterior.png"
                             class="d-block w-100 rounded"
                             style="height:380px; object-fit:cover;"
                             alt="Restaurant Image 1">
                    </div>

                    <div class="carousel-item">
                        <img src="<%=request.getContextPath()%>/assets/images/interior.png"
                             class="d-block w-100 rounded"
                             style="height:380px; object-fit:cover;"
                             alt="Restaurant Image 2">
                    </div>

                    <div class="carousel-item">
                        <img src="<%=request.getContextPath()%>/assets/images/food.png"
                             class="d-block w-100 rounded"
                             style="height:380px; object-fit:cover;"
                             alt="Restaurant Image 3">
                    </div>

                </div>

                <!-- Controls -->
                <button class="carousel-control-prev" type="button"
                        data-bs-target="#aboutCarousel" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </button>

                <button class="carousel-control-next" type="button"
                        data-bs-target="#aboutCarousel" data-bs-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </button>

            </div>

        </div>

        <!-- Content Section -->
        <div class="col-lg-6">
            <h2 class="mb-3">Our Story</h2>
            <p class="text-muted">
                FlavorNest was created with a simple vision — to bring people together through
                great food and warm hospitality. What began as a passion for authentic flavors has grown
                into a place where every meal is crafted with care, quality, and love.
            </p>

            <p class="text-muted">
                From fresh ingredients to hygienic preparation and friendly service, we focus on every
                detail to make your dining experience memorable. Whether you're here for a quick bite,
                a family dinner, or a celebration, we aim to make every visit special.
            </p>

            <a href="<%=request.getContextPath()%>/pages/contact.jsp"
               class="btn btn-warning fw-bold mt-2 px-4">
                Visit Us Today
            </a>
        </div>

    </div>
</div>

<!-- Why People Love Us -->
<div class="container my-5">
    <h2 class="text-center mb-4 fw-bold">Why People Love Us</h2>

    <div class="row g-4 text-center">

        <div class="col-md-3">
            <div class="card border-0 shadow h-100">
                <div class="card-body p-4">
                    <div class="bg-warning rounded-circle d-inline-flex align-items-center justify-content-center mb-3"
                         style="width:60px;height:60px;">
                        <span class="fs-4">🍲</span>
                    </div>
                    <h5 class="fw-bold">Authentic Taste</h5>
                    <p class="text-muted small">
                        Rich flavors crafted to delight every palate.
                    </p>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="card border-0 shadow h-100">
                <div class="card-body p-4">
                    <div class="bg-warning rounded-circle mb-3 d-inline-flex align-items-center justify-content-center"
                         style="width:60px;height:60px;">
                        <span class="fs-4">🥗</span>
                    </div>
                    <h5 class="fw-bold">Fresh Ingredients</h5>
                    <p class="text-muted small">
                        Quality and freshness in every single bite.
                    </p>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="card border-0 shadow h-100">
                <div class="card-body p-4">
                    <div class="bg-warning rounded-circle mb-3 d-inline-flex align-items-center justify-content-center"
                         style="width:60px;height:60px;">
                        <span class="fs-4">⚡</span>
                    </div>
                    <h5 class="fw-bold">Quick Service</h5>
                    <p class="text-muted small">
                        Delicious food served fast without compromise.
                    </p>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="card border-0 shadow h-100">
                <div class="card-body p-4">
                    <div class="bg-warning rounded-circle mb-3 d-inline-flex align-items-center justify-content-center"
                         style="width:60px;height:60px;">
                        <span class="fs-4">❤️</span>
                    </div>
                    <h5 class="fw-bold">Warm Hospitality</h5>
                    <p class="text-muted small">
                        Because every guest deserves to feel welcomed.
                    </p>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Highlight Section -->
<div class="container my-5">
    <div class="card bg-warning text-dark shadow border-0">
        <div class="card-body text-center p-5">
            <h3 class="fw-bold mb-3">
                “Great food is the foundation of genuine happiness.”
            </h3>
            <p class="mb-0">
                At FlavorNest, we don’t just serve meals — we create moments that people remember.
            </p>
        </div>
    </div>
</div>

<jsp:include page="/components/footer.jsp"/>
<jsp:include page="/components/allscripts.jsp"/>

</body>
</html>
