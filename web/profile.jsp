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
<div  class="center" style="padding: 20px; max-width: 500px; margin: 0 auto">
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

    <div class="center card" style="padding: 20px;">
        <form action="products" method="post">
            <h4 class="title">Update Profile</h4>

            <div class="row">
                <div class="input-field col s12 l6 m6" >
                    <input title="text" value="Joakim" disabled class="center">
                </div>
                <div class="input-field col s12 l6 m6" >
                    <input title="text" value="Adeny" disabled class="center">
                </div>

                <div class="input-field col s12 center">
                    <input type="email" name="email" value=""  id="email" required class="validate center">
                    <label for="email">Email address</label>
                </div>

                <div class="input-field col s12 center">
                    <input type="tel" name="phone" value=""  id="phone" required class="validate center">
                    <label for="phone">Phone number</label>
                </div>

                <div class="col s12 center">
                    <p>Leave the new password fields blank if you do not wish to update password.</p>
                </div>

                <div class="input-field col s6 center">
                    <input type="password" name="newpassword"   id="newpassword"  class="center">
                    <label for="newpassword">New password</label>
                </div>

                <div class="input-field col s6 center">
                    <input type="password" name="confirmnewpassword"   id="confirmnewpassword"  class="center">
                    <label for="confirmnewpassword">Confirm password</label>
                </div>


                <div class="input-field col s12 center">
                    <input type="password" name="currentpassword"  id="currentpassword" required class="validate center">
                    <label for="currentpassword">Enter current password</label>
                </div>
            </div>
        </form>
    </div>


</div>
</body>
</html>
