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
    Farm farm = (Farm) request.getAttribute("farm");
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
                    for (Farm farm1: farms) {
                %>
                <tr>
                    <td><%=farm1.getName()%></td>
                    <td><%=farm1.getSize()%>&nbsp;Acres</td>
                    <td><%=farm1.getLocation()%></td>
                    <td>
                        <%
                            if (farm1.getPlants() != null && farm1.getPlants().size() == 0) {
                        %>
                        <a  href="farms?did=<%=farm1.getId()%>" class="btn-small red darken-4"><i class="fa fa-trash"></i>&nbsp;</a>
                        <%
                        }else {
                        %>
                        <a disabled href="farms?did=<%=farm1.getId()%>" class="btn-small red darken-4"><i class="fa fa-trash"></i>&nbsp;</a>
                        <%
                            }
                        %>
                        <a href="farms?eid=<%=farm1.getId()%>" class="btn-small"><i class="fa fa-edit"></i>&nbsp;</a>
                        <a href="plantation?fid=<%=farm1.getId()%>"  class="btn-small green darken-4"><i class="fas fa-seedling"></i>&nbsp;Plantations</a>
                    </td>
                </tr>

                <%
                    }
                %>
            </table>
        </div>

       <%
           if (farm == null) {
       %>
        <div class="col s12 m4 l4">
            <br><br>
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
        <%
            } else {
        %>
        <div class="col s12 m4 l4">
            <br><br>
            <div class="card center" style="padding: 20px">

                <h6 class="center title">Update Farm Details</h6>
                <form action="farms"  method="post">
                    <div class=" form-group">
                        <label>Farm Name</label>
                        <input type="number"  name="id" value="<%=farm.getId()%>" hidden>
                        <input type="text" value="<%=farm.getName()%>"  id="name" name="name" placeholder="Farm name" required="true" class="validate center">
                    </div>

                    <div class=" form-group">
                        <label>Farm Size</label>
                        <input type="number" min="0.0"  value="<%=farm.getSize()%>" name="size" placeholder="Farm size" required="true" class="validate center">
                    </div>
                    <div class=" form-group">
                        <label>Farm Location</label>
                        <input type="text"  value="<%=farm.getLocation()%>" name="location" placeholder="Farm location" required="true" class="validate center">
                    </div>

                    <div>
                        <input type="submit" class="btn green darken-4" name="UpdateFarm" value="update firm">
                    </div>
                </form>
            </div>
        </div>

        <%
            }
        %>

    </div>

</div>
</body>
</html>
