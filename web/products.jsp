<%@ page import="java.util.List" %>
<%@ page import="beans.AnimalProduct" %>
<%@ page import="beans.PlantProduct" %>
<%@ page import="beans.Animal" %>
<%@ page import="components.Cart" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10/8/2020
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<%
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    List<AnimalProduct> animalProducts = (List<AnimalProduct>) request.getAttribute("animal-products");
    List<PlantProduct> plantProducts = (List<PlantProduct>) request.getAttribute("plant-products");
    if (animalProducts == null || plantProducts == null || cart == null) {
        response.sendRedirect("products");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div style="padding: 20px">
    <h5>Available Products</h5>
    <%
        if (request.getAttribute("message") != null) {
    %>
    <div class="alert alert-success center"><%=request.getAttribute("message")%></div>

    <%
        } if (request.getAttribute("error") != null) {
    %>
    <div class="alert alert-danger center"><%=request.getAttribute("error")%></div>
    <%
        }
    %>

    <div>
        <div>
            <div  class="right"><a href="cart" class="btn-small red darken-4 "><i class="fas fa-shopping-cart"></i>&nbsp;Cart(<%=cart.items.size()%>)</a></div>
            <table id="store_table">
                <tr>
                    <th>Product</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Add</th>
                </tr>

                <%
                    for (PlantProduct plantProduct: plantProducts) {
                %>
                <tr>
                    <td><%=plantProduct.getName()%></td>
                    <td><%=plantProduct.getDescription()%></td>
                    <td>Ksh .<%=plantProduct.getPrice()%></td>
                    <td>
                        <a href="products?pc=<%=plantProduct.getId()%>" class="btn-small"><i class="fas fa-cart-plus"></i>Add</a>
                    </td>
                </tr>

                <%
                    } for (AnimalProduct animalProduct: animalProducts) {
                %>
                <tr>
                    <td><%=animalProduct.getName()%></td>
                    <td><%=animalProduct.getDescription()%></td>
                    <td>Ksh .<%=animalProduct.getPrice()%></td>
                    <td>
                        <a href="products?ac=<%=animalProduct.getId()%>" class="btn-small"><i class="fas fa-cart-plus"></i>Add</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </div>


</div>
</body>
</html>
