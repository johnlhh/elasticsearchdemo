<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Highcharts Example</title>

    <script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
    <style type="text/css">
        ${demo.css}

    </style>
    <script type="text/javascript">



        function init(){

            $.post(
                    "http://localhost:8080/elasticsearch/order/v1.0/month_count.do",
                    //type column  pie
                    { year: "2016",showType:"column" },
                    function(data){
                        $('#container').highcharts(data);
                    },
                    "json"
            );
        }
        init();

        var chart;
        $(document).ready(function(){
            $("#search").click(function(){
                chart = $('#container').highcharts();
                chart.setTitle( {text: 'New title search '});
            });
        });
    </script>
</head>
<body>
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts-3d.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>

<div id="container" style="min-width: 310px; height: 560px; margin: 0 auto"></div>
<div id="search">search</div>

</body>
</html>