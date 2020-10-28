<%@ page import="java.util.List" %>
<%@ page import="beans.Order" %>
<%@ page import="beans.User" %><%--
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
    <h5 class="center title">Store Keepers</h5>
    <%
        List<User> users = (List<User>) request.getAttribute("employees");
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
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Register Date</th>
                <th>Action</th>
            </tr>
            <%
                for (User user: users) {
            %>
            <tr>
                <td><%=user%></td>
                <td><%=user.getEmail()%></td>
                <td><%=user.getPhone()%></td>
                <td><%=user.getRegisteredon()%></td>
                <td>
                    <a href="customers?did=<%=user.getId()%>"><i class="fa fa-trash"></i> </a>
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
