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
    <h5 class="center title">Orders</h5>
    <%
        List<Order> orders = (List<Order>) request.getAttribute("orders");
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
<%--            Order(Long id, int userid, String date, String status, double amount)--%>
            <tr>
                <th>ID</th>
                <th>Customer</th>
                <th>Date</th>
                <th>Amount</th>
                <th>Status</th>
                <th>Items</th>
            </tr>
            <%
                for (Order order: orders) {
            %>
            <tr>
                <td><%=order.getId()%></td>
                <td><%=order.getCustomer()%></td>
                <td><%=order.getDate()%></td>
                <td><%=order.getAmount()%></td>
                <td><%=order.getStatus()%></td>
                <td>
                    <a class="btn-small" href="order-items?order=<%=order.getId()%>">See items</a>
                    <a class="btn-small" href="order?complete=<%=order.getId()%>">Complete</a>
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
