<%@ page import="repositories.*" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10/10/2020
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<jsp:include page="templates/nav.jsp"/>
<div style="padding: 20px">
    <h5 class="center title">System Reports</h5>
    <div class="container">
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

        <script type="text/javascript">
            google.charts.load("current", {packages:['corechart']});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ["Type", "Count in the farm", { role: "style" } ],
                    ["Animals", <%=AnimalRepository.all().size()%>, "silver"],
                    ["Plants", <%=PlantRepository.all().size()%>, "gold"],
                ]);

                var view = new google.visualization.DataView(data);
                view.setColumns([0, 1,
                    { calc: "stringify",
                        sourceColumn: 1,
                        type: "string",
                        role: "annotation" },
                    2]);

                var options = {
                    title: "Farm Reports",
                    width: 600,
                    height: 400,
                    bar: {groupWidth: "95%"},
                    legend: { position: "none" },
                };
                var chart = new google.visualization.ColumnChart(document.getElementById("farm_reports"));
                chart.draw(view, options);
            }
        </script>

        <script type="text/javascript">
            google.charts.load("current", {packages:['corechart']});
            google.charts.setOnLoadCallback(drawChartStore);
            function drawChartStore() {
                var data = google.visualization.arrayToDataTable([
                    ["Type", "Count", { role: "style" } ],
                    ["Animal Store Items", <%=AnimalStoreItemRepository.all().size()%>, "red"],
                    ["Plant Store Items", <%=PlantStoreItemRepository.all().size()%>, "green"],
                    ["Equipment Store Items", <%=EquipmentStoreItemRepository.all().size()%>, "black"]
                ]);

                var view = new google.visualization.DataView(data);
                view.setColumns([0, 1,
                    { calc: "stringify",
                        sourceColumn: 1,
                        type: "string",
                        role: "annotation" },
                    2]);

                var options = {
                    title: "Store Items Reports",
                    width: 600,
                    height: 400,
                    bar: {groupWidth: "95%"},
                    legend: { position: "none" },
                };
                var chart = new google.visualization.ColumnChart(document.getElementById("store_reports"));
                chart.draw(view, options);
            }
        </script>

        <script type="text/javascript">
            google.charts.load("current", {packages:['corechart']});
            google.charts.setOnLoadCallback(drawChartProducts);
            function drawChartProducts() {
                var data = google.visualization.arrayToDataTable([
                    ["Source", "Amount", { role: "style" } ],
                    ["Animal Products", <%=AnimalProductRepository.all().size()%>, "red"],
                    ["Plant Products", <%=PlantProductRepository.all().size()%>, "green"],
                ]);

                var view = new google.visualization.DataView(data);
                view.setColumns([0, 1,
                    { calc: "stringify",
                        sourceColumn: 1,
                        type: "string",
                        role: "annotation" },
                    2]);

                var options = {
                    title: "Products Reports",
                    width: 600,
                    height: 400,
                    bar: {groupWidth: "95%"},
                    legend: { position: "none" },
                };
                var chart = new google.visualization.ColumnChart(document.getElementById("products_reports"));
                chart.draw(view, options);
            }
        </script>


        <div class="row">
            <div class="col l6" id="farm_reports" ></div>
            <div  class="col l6" id="products_reports" ></div>
            <div  class="col l12" id="store_reports" ></div>
        </div>
    </div>
</div>
</body>
</html>
