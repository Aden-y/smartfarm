<%@ page import="java.util.List" %>
<%@ page import="beans.EquipmentStoreItem" %><%--
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
    List<EquipmentStoreItem> items = (List<EquipmentStoreItem>) request.getAttribute("items");
    if (items == null) {
        response.sendRedirect("equipment-store");
        return;
    }
    EquipmentStoreItem item1 = (EquipmentStoreItem) request.getAttribute("item");
%>
<div style="padding: 20px">
    <h5 class="title center">Equipments Store</h5>
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

            <table class="highlight">
                <tr>
                    <th>Name</th>
                    <th>Qty</th>
                    <th>Last update</th>
                    <th>Action</th>
                </tr>
                <%
                    for (EquipmentStoreItem item: items) {
                %>
                <tr>
                    <td><%=item.getName()%></td>
                    <td><%=item.getQuantity()%></td>
                    <td><%=item.getUpdatedat()%></td>
                    <td>
                        <a href="equipment-store?did=<%=item.getId()%>" class="btn-small red darken-4"><i class="fa fa-trash"></i>&nbsp;</a>
                        <a href="equipment-store?eid=<%=item.getId()%>"  class="btn-small "><i class="fa fa-edit"></i>&nbsp;</a>
                    </td>
                </tr>

                <%
                    }
                %>
            </table>
        </div>

       <%
           if (item1 == null) {
       %>

        <div class="col s12 m4 l4">
            <div class="card center" style="padding: 20px">
                <h4 class="center title">New Item</h4>
                <form action="equipment-store"  method="post">
                    <div class=" form-group">
                        <%--                    <input type="number"  th:field="*{id}" hidden>--%>
                        <input type="text"  name="name" placeholder="Item name"
                               required="true" class="center validate">
                    </div>
                    <div class="col-md-12 form-group">
                        <label>Quantity in store</label>
                        <input type="number" id="quantity" name="quantity" placeholder="Quantity" required="true"
                               class="center validate" min="0.0">
                    </div>
                    <div class="mb-2">
                        <input type="submit" class="btn green darken-4" name="NewItem" value="Save Item">
                    </div>
                </form>
            </div>
        </div>

        <%
            } else  {
        %>

        <div class="col s12 m4 l4">
            <div class="card center" style="padding: 20px">
                <h4 class="center title">Update Item</h4>
                <form action="equipment-store"  method="post">
                    <div class=" form-group">
                         <input type="number"  name="id" value="<%=item1.getId()%>" hidden>
                        <input type="text"  name="name" placeholder="Item name"
                               required="true" value="<%=item1.getName()%>" class="center validate">
                    </div>
                    <div class="col-md-12 form-group">
                        <label>Quantity in store</label>
                        <input type="number" value="<%=item1.getQuantity()%>" id="quantity" name="quantity" placeholder="Quantity" required="true"
                               class="center validate" min="0.0">
                    </div>
                    <div class="mb-2">
                        <input type="submit" class="btn green darken-4" name="UpdateItem" value="Update Item">
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
