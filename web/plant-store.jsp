<%@ page import="java.util.List" %>
<%@ page import="beans.PlantStoreItem" %><%--
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
    List<PlantStoreItem> items = (List<PlantStoreItem>) request.getAttribute("items");
    if (items == null) {
        response.sendRedirect("plant-store");
        return;
    }
%>
<div style="padding: 20px">
    <h5 class="center title">Plants Store</h5>
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
        <div class="col s12 m4 l4">
            <table class="highlight">
                <tr>
                    <th>Name</th>
                    <th>Qty</th>
                    <th>Last update</th>
                    <th>Action</th>
                </tr>
                <%
                    for (PlantStoreItem item: items) {
                %>
                <tr>
                    <td><%=item.getName()%></td>
                    <td><%=item.getQuantity()%>&nbsp;<%=item.getUnits()%></td>
                    <td><%=item.getUpdatedat()%></td>
                    <td>
                        <a href="plants-store?did=<%=item.getId()%>" class="btn-small red darken-4"><i class="fa fa-trash"></i>&nbsp;Delete</a>
                        <a href="plants-store?eid=<%=item.getId()%>"  class="btn-small "><i class="fa fa-info"></i>&nbsp;Edit</a>
                    </td>
                </tr>

                <%
                    }
                %>
            </table>
        </div>

        <div class="col s12 m8 l8">
            <div class="card center" style="padding: 20px">
                <h6 class="center title">New Item</h6>
                <form action="plants-store" method="post">
                    <div class=" form-group">
                        <label>Item Name</label>
<%--                        <input type="number" hidden th:field="*{id}">--%>
                        <input type="text"  id="name" name="name" placeholder="Item name"
                               required="true" class="center validate">
                    </div>
                    <div class="row">
                        <div class="col s6">
                            <label>Units </label>
                            <input type="text"  id="units" name="units" placeholder="Units of measure e.g kgs, ltrs ..."
                                   required="true" class="center validate">
                        </div>

                        <div class="col s6">
                            <label>Quantity in store</label>
                            <input type="number"  id="quantity" name="quantity"
                                   placeholder="Quantity" required="true" class="center validate" min="0.0">
                        </div>
                    </div>
                    <div >
                        <input type="submit" class="btn green darken-4" name="NewItem" value="Save">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
