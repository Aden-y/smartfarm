<%@ page import="beans.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10/8/2020
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("user");
%>
<nav class="green darken-4" role="navigation">
    <div class="nav-wrapper"><a id="logo-container" href="#" class="brand-logo" style="padding-left: 10px;">SmartFarm</a>



        <ul class="right hide-on-med-and-down">
            <%
                if(user == null) {
            %>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="products">Shop</a></li>
            <li><a href="register">Sign up</a></li>
            <%
                }else {
                    if (user.getType().equals("Customer")) {
            %>

            <li><a href="products">Shop</a></li>
            <li><a href="orders">My Orders</a></li>
            <%
                }else {
                        if (user.getType().equals("Farm Owner")) {
            %>
            <li><a href="orders">Orders</a></li>
            <li><a class="dropdown-trigger" href="#!" data-target="users">
                Manage Users
                <i class="material-icons right">arrow_drop_down</i>
            </a></li>
            <ul id="users" class="dropdown-content green darken-4">
                <li><a href="register">Add employee</a></li>
                <li><a href="employees">Store Keepers</a></li>
                <li><a href="customers">Customers</a></li>
            </ul>
            <%
                }
            %>
            <li><a class="dropdown-trigger" href="#!" data-target="farm">
                Manage Farm
                <i class="material-icons right">arrow_drop_down</i>
            </a>
            </li>

            <li><a class="dropdown-trigger" href="#!" data-target="store">
                Manage Store
                <i class="material-icons right">arrow_drop_down</i>
            </a></li>

            <ul id="farm" class="dropdown-content green darken-4">
                <li><a href="farms">Farms</a></li>
                <li><a href="animals">Animals</a></li>
            </ul>

            <ul id="store" class="dropdown-content green darken-4">
                <li><a href="animal-store">Animal Store</a></li>
                <li><a href="plant-store">Plant Store</a></li>
                <li><a href="equipment-store">Equipment Store</a></li>
            </ul>

            <%
                }
            %>
            <li>
                <a href="#" class="dropdown-trigger" data-target="profile">
                    <i class="valign-wrapper">
                        <img  style="height: 30px; width: 30px;" src="assets/img/1.jpg" alt="" class="responsive-img circle valign-wrapper">
                        &nbsp;
                        <span style="font-style: normal; font-size: 14px"><%=user%></span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </i>
                </a>
            </li>
            <ul id="profile" class="dropdown-content green darken-4">
                <li><a href="profile">Profile</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
            <%

                }
            %>
        </ul>

        <ul id="nav-mobile" class="sidenav">
            <li><a href="#">Navbar Link</a></li>
        </ul>
        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
    <script>
        $('.dropdown-trigger').dropdown();
    </script>
</nav>
