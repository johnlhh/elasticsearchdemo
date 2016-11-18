<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/10/19
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Highcharts Example</title>

  <script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
  <style type="text/css">
    #container{
      min-width: 310px;
      max-width: 800px;
      margin: 0 auto;
    }
    #container {
      height: 400px;
    }
  </style>
  <script type="text/javascript">


    /*function init(){
      $.post(
              "http://localhost:8080/elasticsearch/order/v1.0/month_count.do",
              { "year": "2016" },
              function(data){
                alert(data.toString);
                //$('#container').highcharts(data);
                var chart = new Highcharts.Chart(data);
              },
              "json"
      );
    }*/


    $(function () {

      $.post(
              "http://localhost:8080/elasticsearch/order/v1.0/month_count.do",
              { "year": "2016" , showType:"column" },
              function(data){
                var chart = new Highcharts.Chart(data);
              },
              "json"
      );



    });
  </script>
</head>
<body>
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts-3d.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>

<div id="container"></div>

</body>
</html>

