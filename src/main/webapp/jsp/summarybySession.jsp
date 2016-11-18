<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Highcharts Example</title>

  <script type="text/javascript" src="../js/hightcharts/js/jquery-1.8.3.min.js"></script>
  <style type="text/css">
    ${demo.css}

  </style>
  <script type="text/javascript">
    function init(){
      $.post(
              "http://192.168.9.217:8080/elasticsearch/data/show/v1.0/city_src_summary.do",
              //type column  pie
              { title: "以展届为轴的数据统计",
                subTitle: "APP渠道分析",
                city_id: 1,
                src: "APP",
                xColumn: "session",
                lineTypesStr:"get_ticket,check_ticket,check_ticket_person,order_count,order_person_count",
                showType:"line"
              },
              function(data){
                  setTimeout(function(){
                      $('#container').highcharts(data);
                      cityChangeForSrc();
                  },100);

              },
              "json"
      );
    }
    init();

    function initSelectSrc(srcArr){
        $("#src").empty();
        var flag = $("#src").val() == null?true:false;
        for(var i = 0 ; i < srcArr.length; i++){
            if((flag && srcArr[i] == "APP")|| srcArr[i] == $("#src").val()){
                $("#src").append("<option value='"+srcArr[i]+"' selected='selected'>"+srcArr[i]+"</option>");
            }else{
                $("#src").append("<option value='"+srcArr[i]+"'>"+srcArr[i]+"</option>");
            }
        }
    }

    function cityChangeForSrc(){
        $.post(
                "http://192.168.9.217:8080/elasticsearch/data/show/v1.0/src_list.do",
                {
                    city_id: $("#city").val() == null?1:$("#city").val(),
                },
                function(data){
                    initSelectSrc(data);
                },
                "json"
        );
    }

    var lineTypes = "get_ticket,check_ticket,check_ticket_person,order_count,order_person_count".split(",");
      function checkbox(obj){
          var value = obj.value ;
          if(value == "" || value == undefined){
              return;
          }
          var len = lineTypes.length;
          if(len != 0){
              for(var i = 0 ; i < len ; i++){
                  if(lineTypes[i] == value){
                      lineTypes.splice(i,1);break;
                  }else if(i == len -1){
                      lineTypes.push(value);
                  }
              }
          }else{
              lineTypes.push(value);
          }
      }
      function toString(obj,split){
          var str="";
          for(var i = 0 ; i < obj.length;i++){
              if(i == obj.length -1) split = "";
              str += obj[i]+split;
          }
          return str;
      }

    function getSelectTextById(id){
        var obj=document.getElementById(id);
        for(i=0;i<obj.length;i++) {//下拉框的长度就是他的选项数
            if(obj[i].selected==true) {
                return obj[i].text;//获取文本
            }
        }
    }

      function show(){
          $.post(
                  "http://192.168.9.217:8080/elasticsearch/data/show/v1.0/city_src_summary.do",
                  //type column  pie
                  {   title: $('#title').val(),
                      subTitle: getSelectTextById("city")+$('#src').val()+"渠道分析",
                      city_id: $('#city').val(),
                      src: $('#src').val(),
                      xColumn: $('#xColumn').val(),
                      lineTypesStr:toString(lineTypes,","),
                      showType:$('#showType').val(),
                      orderType:$('#orderType').val(),
                      limit:$('#limit').val()
                  },
                  function(data){
                      $('#container').highcharts(data);
                  },
                  "json"
          );
      }
    function titleChange(){
        var title = $("#title").val();
        switch (title){
            case "以渠道为轴的数据统计": window.location.href = "http://192.168.9.217:8080/elasticsearch/jsp/summarybySrc.jsp";break;
            case "以展届为轴的数据统计":window.location.href = "http://192.168.9.217:8080/elasticsearch/jsp/summarybySession.jsp";break;
        }
    }
  </script>
</head>
<body>
<%--<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts-3d.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>--%>
<script src="../js/hightcharts/js/highcharts.js"></script>
<script src="../js/hightcharts/js/highcharts-3d.js"></script>
<script src="../js/hightcharts/js/modules/exporting.js"></script>

<div id="filter" style="min-width: 310px; max-width: 1000px; height: 200px; margin:0 auto">

     <!--  主题选择  -->
     <label style="">主題：</label>
     <select id="title" style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 30px" onchange="titleChange()">
         <option value="以渠道为轴的数据统计">以渠道为轴的数据统计</option>
         <option value="以展届为轴的数据统计" selected="selected">以展届为轴的数据统计</option>
     </select>

    <!--  城市选择  -->
    <label style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 30px; margin-left: 20px;">城市：</label>
    <select id="city" style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 30px;" onchange="cityChangeForSrc()">
        <option value="1">上海</option>
        <option value="2">北京</option>
    </select>

    <!--  渠道选择  -->
    <label style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 30px; margin-left: 20px;">渠道：</label>
    <select id="src" style="min-width: 30px; max-width: 80px; height: 30px; margin-top: 30px;">

    </select>

    <!--  展示类型选择  -->
    <label style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 30px; margin-left: 20px;">展示类型：</label>
    <select id="showType" style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 30px;">
        <option value="line" selected="selected">线性图表</option>
        <option value="column">柱型图表</option>
        <option value="pie">饼型图表</option>
    </select>

    <!--  X轴分类选择  -->
    <label style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 30px; margin-left: 20px;">X轴选择：</label>
    <select id="xColumn" style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 30px;">
        <option value="session">展届</option>
    </select>

    <!--  X轴的长度  -->
    <label style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 30px; margin-left: 20px;">x-limit</label>
    <select id="limit" style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 30px;">
        <option value="10" selected="selected">10</option>
        <option value="20">20</option>
        <option value="30">30</option>
    </select>

    <!--  线性点选择  -->

    <div style="min-width: 100px; max-width: 100px; height: 10px;margin-top: 10px;"></div>
    <div style="position: absolute;left: 930px;margin-top: 0px;"><input type="button" value="show" onclick="show()"  /> </div>

    <label style="min-width: 30px; max-width: 180px; height: 20px; margin-top: 0px;">线性点选择：</label>
    <div id="pointList" style="min-width: 30px; max-width: 180px; height: 100px;">
        <div style="min-width: 30px; max-width: 180px;height: 20px; margin:0 auto"> <input type="checkbox" value="get_ticket" onclick="checkbox(this)" checked="checked" > 索票量 </div>
        <div style="min-width: 30px; max-width: 180px;height: 20px; margin:0 auto"> <input type="checkbox" value="check_ticket" onclick="checkbox(this)" checked="checked"> 检票量  </div>
        <div style="min-width: 30px; max-width: 180px;height: 20px; margin:0 auto"> <input type="checkbox" value="check_ticket_person" onclick="checkbox(this)" checked="checked"> 验票人数 </div>
        <div style="min-width: 30px; max-width: 180px;height: 20px; margin:0 auto"> <input type="checkbox" value="order_count" onclick="checkbox(this)" checked="checked"> 订单总数 </div>
        <div style="min-width: 30px; max-width: 180px;height: 20px; margin:0 auto"> <input type="checkbox" value="order_person_count" onclick="checkbox(this)" checked="checked" >下单人数 </div>
    </div>

    <!--  排序  -->
    <label style="position: absolute;left: 660px;top: 88px;">排序：</label>
    <select id="orderType" style="position: absolute;left: 660px;top: 118px;">
        <option value="0">升序</option>
        <option value="1">降序</option>
    </select>
</div>
<div id="container" style="min-width: 310px; max-width: 1000px; height: 360px; margin:0 auto"></div>

</body>
</html>