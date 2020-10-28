<%@ page import="components.Cart" %>
<%@ page import="beans.OrderItem" %><%--
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
<jsp:include page="templates/nav.jsp"/>
<div style="padding: 20px">
    <h5 class="center title">Products in cart</h5>
    <%
        Cart cart = (Cart) session.getAttribute("cart");
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
        <table class="highlight">
            <tr>
                <th>Product</th>
                <th>Description</th>
                <th>Price</th>
                <th>Qty</th>
                <th>Amount</th>
                <th>Action</th>
            </tr>
            <%
                for (OrderItem item: cart.items) {
            %>
            <tr>
                <td><%=item.getName()%></td>
                <td><%=item.getDescription()%></td>
                <td><%=item.getPrice()%></td>
                <td><%=item.getQuantity()%></td>
                <td><%=item.getAmount()%></td>
                <td>
                    <a href="cart?did=<%=item.getId()%>" class="btn-small red darken-4"><i class="fa fa-trash"></i>&nbsp;remove</a>
                </td>
            </tr>
            <%
                }
            %>

        </table>
    </div>
</div>
</body>
</html>
