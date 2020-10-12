<%@ page import="java.util.List" %>
<%@ page import="beans.Animal" %><%--
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
    List<Animal> animals = (List<Animal>) request.getAttribute("animals");
    if (animals == null) {
        response.sendRedirect("animals");
        return;
    }

%>
<div style="padding: 20px">
    <h5 class="title center">Animals in the farm</h5>
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
        <div  class="col s12 l8 m8">

            <table class="highlight">
                <tr>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Breed</th>
                    <th>Gender</th>
                    <th>Count</th>
                    <th>Action</th>
                </tr>
                <%
                    for (Animal animal: animals) {
                %>
                <tr>
                    <td><%=animal.getName()%></td>
                    <td><%=animal.getCategory()%></td>
                    <td><%=animal.getBreed()%></td>
                    <td><%=animal.getGender()%></td>
                    <td><%=animal.getCount()%></td>
                    <td>
                        <a href="animals?eid=<%=animal.getId()%>" class="btn-small"><i class="fa fa-info"></i>&nbsp;Edit</a>
                        <a  href="animals?did=<%=animal.getId()%>" class="btn-small red darken-4"><i class="fa fa-trash"></i>&nbsp;Delete</a>
                        <a  href="animal-products?a=<%=animal.getId()%>" class="btn-small green darken-4">&nbsp;Products</a>
                    </td>
                </tr>

                <%
                    }
                %>
            </table>
        </div>

        <div class="col s12 l4 m4">


            <form action="animals" method="post">
                <div style="padding: 20px" class="center card">
                    <h6 class="title center">New Animal</h6>
                    <div class=" form-group">
                        <%--                    <input type="number" hidden th:field="*{id}" >--%>
                        <input type="text"  id="name" name="name" placeholder="Animal name" required="true" class="center validate">
                    </div>

                    <div class=" form-group">
                        <input type="text" id="category" name="category" placeholder="Animal Category" required="true" class="validate center" >
                    </div>

                    <div class=" form-group">
                        <label>Animal Gender</label>
                        <select id="gender" name="gender" required="true" class="center validate">
                            <option value="">...</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
                    </div>

                    <div class=" form-group">
                        <input type="text"  id="breed" name="breed" placeholder="Animal Breed" class="validate center" required>
                    </div>

                    <div class=" form-group">
                        <input type="text" id="color" name="color" placeholder="Animal Color" class="center validate" required>
                    </div>

                    <div class=" form-group">
                        <label >Weight</label>
                        <input type="number" min="0.0" id="weight" name="weight"  class="center validate">
                    </div>

                    <div class=" form-group">
                        <label>Count</label>
                        <input type="number"  id="count" name="count" min="1" value="1" class="center validate">
                    </div>

                    <div class=" form-group">
                        <input type="date" id="dob" name="dob" class="center validate" >
                    </div>

                    <div>
                        <input type="submit" class="btn-small green darken-4" value="Save animal" name="NewAnimal">
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
</body>

</html>
