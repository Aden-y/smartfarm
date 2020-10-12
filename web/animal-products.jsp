<%@ page import="beans.Animal" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.AnimalProduct" %><%--
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
    Animal animal = (Animal) request.getAttribute("animal");
    List<AnimalProduct> products = (List<AnimalProduct>) request.getAttribute("products");

    if (products == null || animal == null) {
        response.sendRedirect("animals");
        return;
    }
%>
<div style="padding: 20px">
    <h5 class="center title">Products from animal <%=animal.getName()%></h5>
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
                    <th>Desc</th>
                    <th>Qty</th>
                    <th>Action</th>
                </tr>
                <%
                    for (AnimalProduct product: products) {
                %>
                <tr>
                    <td><%=product.getName()%></td>
                    <td><%=product.getDescription()%></td>
                    <td><%=product.getQuantity()%></td>
                    <td>
                        <a href="animal-products?did=<%=product.getId()%>" class="btn-small red darken-4"><i class="fa fa-trash"></i>delete</a>
                        <a href="animal-products?eid=<%=product.getId()%>"  class="btn-small"><i class="fa fa-edit"></i>Edit</a>
                    </td>
                </tr>

                <%
                    }
                %>
            </table>
        </div>

        <div class="col s12 m4 l4">
           <div class="center card" style="padding: 20px">
               <h6 class="title center">Add a product from this animal</h6>
               <form action="animal-products" method="post">

                   <div class=" form-group">
                       <%--                    <input type="number" hidden th:field="*{id}" >--%>
                       <input name="animalid" value="<%=animal.getId()%>" hidden>
                       <input type="text"  name="name" placeholder="Item name"
                              required="true" class="validate center">
                   </div>

                   <div class=" form-group">
                       <label>Item Description</label>
                       <textArea  id="description" name="description" style="width: 100%; height: 200px;" ></textArea>
                   </div>
                   <div class="form-group">
                       <input type="text" id="units" name="units"
                              placeholder="Units of measure e.g kgs, ltrs ..."
                              required="true" class="center validate">
                   </div>
                   <div class="form-group">
                       <label>Unit Price</label>
                       <input type="number"  id="price" name="price"
                              placeholder="Unit price" required="true" class="validate center" min="0.0">
                   </div>
                   <div class="form-group">
                       <label>Quantity in store</label>
                       <input type="number"  id="quantity" name="quantity"
                              placeholder="Quantity" required="true" class="center validate" min="0.0">
                   </div>
                   <div>
                       <input type="submit" name="NewProduct" class="btn green darken-4" value="Save Product">
                   </div>
               </form>
           </div>
        </div>
    </div>


</div>
</body>
</html>
