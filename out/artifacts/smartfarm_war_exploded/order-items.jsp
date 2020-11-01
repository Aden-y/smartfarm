<%@ page import="components.Cart" %>
<%@ page import="beans.OrderItem" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Order" %><%--
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
    <h5 class="center title">Order Items</h5>
    <%
        List<OrderItem> items = (List<OrderItem>) request.getAttribute("items");
        Order order = (Order) request.getAttribute("order");
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
            </tr>
            <%
                for (OrderItem item: items) {
            %>
            <tr>
                <td><%=item.getName()%></td>
                <td><%=item.getDescription()%></td>
                <td><%=item.getPrice()%></td>
                <td><%=item.getQuantity()%></td>
                <td><%=item.getAmount()%></td>
            </tr>
            <%
                }
            %>
            <tr>
                <td colspan="4"><strong>Total</strong></td>
                <td colspan="2"><strong>Ksh <%=order.getAmount()%></strong></td>
            </tr>

        </table>
    </div>
</div>
</body>
</html>
