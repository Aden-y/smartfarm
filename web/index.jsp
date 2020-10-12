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
      <form  action="auth"  method="post">
        <div class="card" style="padding: 20px">
          <div class="card-header text-center"><h4>Login</h4></div>

          <div class="card-body">
            <div class="form-group">
              <label>Email Address</label>
              <input type="email"   name="email" placeholder="Enter login email" required="true" class="validate center">
            </div>

            <div class="form-group">
              <label>Password</label>
              <input type="password" name="password" placeholder="Enter password" required="true" class="validate center">
            </div>
          </div>
          <div class="center">
            <button type="submit" class="btn green darken-4">Login</button>
            <br><br>
           <a href="register.jsp">Create account..</a>
          </div>
        </div>
      </form>
    </div>
  </div>
  </body>
</html>
