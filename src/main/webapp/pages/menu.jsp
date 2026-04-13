<%@ page import="java.util.*, all.model.MenuItem" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Our Menu</title>
    <jsp:include page="/components/allcdns.jsp"/>
</head>
<body class="bg-light">

<jsp:include page="/components/navbar.jsp"/>

<div class="container my-5">

    <!-- Heading -->
    <div class="text-center mb-4">
        <h1 class="fw-bold">Our Signature Menu</h1>
        <p class="text-muted">Crafted with passion, served with perfection.</p>
    </div>

    <!-- Category Filter -->
    <div class="text-center mb-4">
        <button class="btn btn-warning m-1" onclick="filterCategory('All')">All</button>
        <button class="btn btn-outline-warning m-1" onclick="filterCategory('Starters')">Starters</button>
        <button class="btn btn-outline-warning m-1" onclick="filterCategory('Soups')">Soups</button>
        <button class="btn btn-outline-warning m-1" onclick="filterCategory('Main Course')">Main Course</button>
        <button class="btn btn-outline-warning m-1" onclick="filterCategory('Chinese')">Chinese</button>
        <button class="btn btn-outline-warning m-1" onclick="filterCategory('Pasta & Pizza')">Pasta & Pizza</button>
        <button class="btn btn-outline-warning m-1" onclick="filterCategory('Desserts')">Desserts</button>
        <button class="btn btn-outline-warning m-1" onclick="filterCategory('Beverages')">Beverages</button>
    </div>

    <!-- Menu Items -->
    <div class="row g-4" id="menuContainer">

        <%
            List<MenuItem> menuList = (List<MenuItem>) request.getAttribute("menuList");

            if(menuList != null){
                for(MenuItem item : menuList){
        %>

        <div class="col-md-3 menu-item" data-category="<%=item.getItemCategory()%>">
            <div class="card shadow-sm border-0 h-100">

                <!-- Image -->
                <img loading="lazy" src="<%=request.getContextPath()%>/assets/images/menu/<%=item.getImagePath()%>"
                     class="card-img-top"
                     style="height:180px; object-fit:cover;">

                <div class="card-body text-center">
                    <h6 class="fw-bold"><%=item.getItemName()%></h6>
                    <p class="text-muted small mb-1"><%=item.getItemCategory()%></p>
                    <h6 class="text-warning fw-bold">₹ <%=item.getItemPrice()%></h6>

                    <!-- Add to Cart Button -->
                    <form action="<%=request.getContextPath()%>/AddToCart" method="post">
                        <input type="hidden" name="itemId" value="<%=item.getItemId()%>">
                        <input type="hidden" name="itemName" value="<%=item.getItemName()%>">
                        <input type="hidden" name="price" value="<%=item.getItemPrice()%>">

                        <button class="btn btn-warning btn-sm w-100 mt-2">
                            Add to Cart
                        </button>
                    </form>

                </div>
            </div>
        </div>

        <%
                }
            }
        %>

    </div>

</div>

<jsp:include page="/components/footer.jsp"/>
<jsp:include page="/components/allscripts.jsp"/>

<!-- Category Filter Script -->
<script>
function filterCategory(category) {
    let items = document.getElementsByClassName("menu-item");

    for (let i = 0; i < items.length; i++) {
        let itemCategory = items[i].getAttribute("data-category");

        if (category === "All" || itemCategory === category) {
            items[i].style.display = "block";
        } else {
            items[i].style.display = "none";
        }
    }
}
</script>

</body>
</html>
