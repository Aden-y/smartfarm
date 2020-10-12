<%--
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
<br>
<div style="padding: 20px">
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

    <div class="container mt-3">
        <h4 class="center title">Products in cart</h4>

        <table id="store_table">
            <tr>
                <th>Product</th>
                <th>Description</th>
                <th>Price</th>
                <th>Amount</th>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <a href="cart?did=" class="btn-small red darken-4"><i class="fa fa-trash"></i>remove</a>
                </td>
            </tr>

        </table>
    </div>
</div>
</body>
</html>
