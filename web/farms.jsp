<%@ page import="java.util.List" %>
<%@ page import="beans.Farm" %><%--
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
<%
    List<Farm> farms = (List<Farm>) request.getAttribute("farms");
    if (farms == null) {
        response.sendRedirect("farms");
        return;
    }
%>
<div style="padding: 20px">
    <h5 class="center title">Farms</h5>
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

    <div class="row">
        <div class="col s12 m8 l8">
            <table>
                <tr>
                    <th>NAME</th>
                    <th>SIZE</th>
                    <th>LOCATION</th>
                    <th>ACTION</th>
                </tr>
                <%
                    for (Farm farm: farms) {
                %>
                <tr>
                    <td><%=farm.getName()%></td>
                    <td><%=farm.getSize()%>&nbsp;Acres</td>
                    <td><%=farm.getLocation()%></td>
                    <td>
                        <a  href="farms?did=<%=farm.getId()%>" class="btn-small red darken-4"><i class="fa fa-trash"></i>&nbsp;Delete</a>
                        <a href="farms?eid=<%=farm.getId()%>" class="btn-small"><i class="fa fa-edit"></i>&nbsp;Edit</a>
                        <a href="plantation?fid=<%=farm.getId()%>"  class="btn-small green darken-4"><i class="fas fa-seedling"></i>&nbsp;Plantations</a>
                    </td>
                </tr>

                <%
                    }
                %>
            </table>
        </div>

        <div class="col s12 m4 l4">

            <div class="card center" style="padding: 20px">
                <h6 class="center title">New Farm</h6>
                <form action="farms"  method="post">
                    <div class=" form-group">
                        <label>Farm Name</label>
                        <%--                    <input type="number"  th:field="*{id}" hidden>--%>
                        <input type="text"  id="name" name="name" placeholder="Farm name" required="true" class="validate center">
                    </div>

                    <div class=" form-group">
                        <label>Farm Size</label>
                        <input type="number" min="0.0"  name="size" placeholder="Farm size" required="true" class="validate center">
                    </div>
                    <div class=" form-group">
                        <label>Farm Location</label>
                        <input type="text"   name="location" placeholder="Farm location" required="true" class="validate center">
                    </div>

                    <div>
                        <input type="submit" class="btn green darken-4" name="NewFarm" value="save Farm">
                    </div>
                </form>
            </div>
        </div>

    </div>

</div>
</body>
</html>
