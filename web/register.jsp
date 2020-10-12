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
<br><br>
<div class="container center" style="max-width:  400px;">
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
    <div  class="p-2">
        <form action="#" action="register" method="post">
            <div class="card" style="padding: 20px">
                <div class="center title"><h4>Customer Registration</h4></div>

                <div class="card-body">
                    <div class="row">
                        <div class="col s12 m6 l6">
                            <label>First name</label>
                            <input type="text"  id="firstname" name="firstname" placeholder="Enter first name" required="true" class="validate center">
                        </div>

                        <div class="col s12 m6 l6">
                            <label>Last  name</label>
                            <input type="text"  id="lastname" name="lastname" placeholder="Enter last name" required="true" class="validate center">
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Email Address</label>
                        <input type="email"  id="email" name="email" placeholder="Enter email" required="true" class="validate center">
                    </div>

                    <div class="form-group">
                        <label>Phone number</label>
                        <input type="tel" id="phone" name="phone" placeholder="Enter phone number" required="true" class="validate center">
                    </div>
                </div>
                <div class="card-footer text-center">
                    <button type="submit" class="btn green darken-4">Sign up</button>
                    <br><br>

                    <a href="index.jsp">Sign in</a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
