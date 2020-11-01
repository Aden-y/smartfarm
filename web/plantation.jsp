<%@ page import="java.util.List" %>
<%@ page import="beans.Plant" %>
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
<%
    Farm farm = (Farm) request.getAttribute("farm");
    Plant plant1 = (Plant) request.getAttribute("plant");
    List<Plant> plants = (List<Plant>) request.getAttribute("plants");

    if (farm == null || plants == null) {
        response.sendRedirect("farms");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div style="padding: 20px">
    <h5 class="center title"><%=farm.getName()%>&nbsp; Plantation</h5>
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
       <div class="col s12 l8 m8">
           <table>
               <tr>
                   <th>Name</th>
                   <th>Category</th>
                   <th>Description</th>
                   <th>Roots Count</th>
                   <th>Date Planted</th>
                   <th>Action</th>
               </tr>
               <%
                   for (Plant plant: plants) {
               %>
               <tr>
                   <td><%=plant.getName()%></td>
                   <td><%=plant.getCategory()%></td>
                   <td><%=plant.getDescription()%></td>
                   <td><%=plant.getRootscount()%></td>
                   <td><%=plant.getPlantedon()%></td>
                   <td>
                       <%
                           if (plant.getProducts() != null && plant.getProducts().size() == 0) {
                       %>
                       <a href="plantation?did=<%=plant.getId()%>" class="btn-small red darken-4"><i class="fa fa-trash"></a>
                       <%
                           }else {
                       %>
                       <a disabled href="plantation?did=<%=plant.getId()%>" class="btn-small red darken-4"><i class="fa fa-trash"></i></a>
                       <%
                           }
                       %>
                       <a href="plantation?eid=<%=plant.getId()%>" class="btn-small"><i class="fa fa-edit"></i></a>
                       <a href="plant-products?p=<%=plant.getId()%>" class="btn-small green darken-4">Products</a>
                   </td>
               </tr>

               <%
                   }
               %>
           </table>
       </div>

       <%
           if (plant1 == null) {
       %>

       <div class="col s12 l4 m4">
           <div class="card center" style="padding: 20px">
               <h6 class="center title">Add Plant to this firm</h6>
               <form action="plantation"  method="post">
                   <div class=" form-group">
                       <%--                       <input type="number" th:field="*{id}" hidden>--%>
                       <input type="number" value="<%=farm.getId()%>" name="farmid" hidden>
                       <input type="text"  id="name" name="name" placeholder="Plant name"
                              required="true" class="center validate">
                   </div>

                   <div class=" form-group">
                       <input type="text"  id="category"
                              name="category" placeholder="Plant category " required="true" class="center validate">
                   </div>

                   <div class="form-group">
                       <textarea  id="description" name="description"  class="center"
                                  placeholder="Plant description " required="true" style="width:100%; height: 200px;">

                       </textarea>
                   </div>

                   <div class=" form-group">
                       <input type="number"  id="rootscount" name="rootscount" placeholder="Roots(optional)" class="center">
                   </div>

                   <div class=" form-group">
                       <label>Planted on <span>(optional)</span></label>
                       <input type="date"   id="plantedon" name="plantedon" placeholder="Date planted" class="center">
                   </div>


                   <div>
                       <input type="submit" class="btn green darken-4" name="NewPlant" value="Save">
                   </div>
               </form>
           </div>
       </div>
       <%
           } else  {
       %>

       <div class="col s12 l4 m4">
           <div class="card center" style="padding: 20px">
               <h6 class="center title">Edit Plant Details</h6>
               <form action="plantation"  method="post">
                   <div class=" form-group">
                     <input type="number" name="id" value="<%=plant1.getId()%>" hidden>
                       <input type="number" value="<%=farm.getId()%>" name="farmid" hidden>
                       <input type="text" value="<%=plant1.getName()%>"  id="name" name="name" placeholder="Plant name"
                              required="true" class="center validate">
                   </div>

                   <div class=" form-group">
                       <input type="text"  id="category" value="<%=plant1.getCategory()%>"
                              name="category" placeholder="Plant category " required="true" class="center validate">
                   </div>

                   <div class="form-group">
                       <textarea  id="description"  value="<%=plant1.getDescription()%>"name="description"  class="center"
                                  placeholder="Plant description " required="true" style="width:100%; height: 200px;">

                       </textarea>
                   </div>

                   <div class=" form-group">
                       <input type="number" value="<%=plant1.getRootscount()%>"  id="rootscount" name="rootscount" placeholder="Roots(optional)" class="center">
                   </div>

                   <div class=" form-group">
                       <label>Planted on <span>(optional)</span></label>
                       <input type="date"  value="<%=plant1.getPlantedon()%>"  id="plantedon" name="plantedon" placeholder="Date planted" class="center">
                   </div>


                   <div>
                       <input type="submit" class="btn green darken-4" name="UpdatePlant" value="Update Plant">
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
