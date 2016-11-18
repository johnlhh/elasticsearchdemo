<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="../plugins/chosen_v1.6.2/docsupport/style.css">
    <link rel="stylesheet" href="../plugins/chosen_v1.6.2/docsupport/prism.css">
    <link rel="stylesheet" href="../plugins/chosen_v1.6.2/chosen.css">
    <title>Highcharts Example</title>

    <script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
    <style type="text/css">
        ${demo.css}

    </style>
    <script type="text/javascript">
        function init(){
            $.post(
                    "http://localhost:8080/elasticsearch/data/show/v1.0/city_session_summary.do",
                    //type column  pie
                    { title: "城市展届汇总表",
                        subTitle: "渠道分析",
                        city_id: 1,
                        session: 21,
                        xColumn: "src",
                        lineTypesStr:"get_ticket,check_ticket,check_ticket_person,order_count,order_person_count",
                        showType:"line"
                    },
                    function(data){
                        $('#container').highcharts(data);
                    },
                    "json"
            );
        }
        init();
        var lineTypes = new Array();
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

        function show(){
            $.post(
                    "http://localhost:8080/elasticsearch/data/show/v1.0/city_session_summary.do",
                    //type column  pie
                    {   title: $('#title').val(),
                        subTitle: "上海"+$('#session').val()+"届展会渠道分析",
                        city_id: $('#city').val(),
                        session: $('#session').val(),
                        xColumn: $('#xColumn').val(),
                        lineTypesStr:$("#linedots").val(),
                        showType:$('#showType').val()
                    },
                    function(data){
                        $('#container').highcharts(data);
                    },
                    "json"
            );
        }

       /* function test(){
            alert($("#linedots").val());
        }*/
    </script>
</head>
<body>
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts-3d.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>
<div id="filter" style="min-width: 310px; max-width: 850px; height: 200px; margin:0 auto">
    <form>
        <div id="container1">
            <div id="content">
                <div class="side-by-side clearfix">
                    <div style="min-width: 30px; max-width: 180px; height: 30px;">
                        <em>主題：</em>
                        <select id="title" data-placeholder="请选择主题"  class="chosen-select-no-results" tabindex="1">
                            <option value="" selected="selected"></option>
                            <option value="城市展届汇总表">城市展届汇总表</option>
                            <option value="城市展届">城市展届</option>
                            <option value="城市展届汇总表">城市展届汇总表</option>
                        </select>
                    </div>

                    <div style="min-width: 30px; max-width: 180px; height: 30px;">
                        <em>城市：</em>
                        <select id="city" data-placeholder="请选择城市" style="width:150px;" class="chosen-select-no-results" tabindex="2">
                            <option value="" selected="selected"></option>
                            <option value="1">上海</option>
                            <option value="2">北京</option>
                        </select>
                    </div>

                    <div style="min-width: 30px; max-width: 180px; height: 30px;">
                        <em>展届：</em>
                        <select id="session" data-placeholder="Type &apos;C&apos; to view" style="width:100px;" class="chosen-select-no-results" tabindex="3">
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21" selected="selected">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                        </select>
                    </div>

                    <div style="min-width: 30px; max-width: 180px; height: 30px;">
                        <em>展示类型：</em>
                        <select id="showType" data-placeholder="" style="width:150px;" class="chosen-select-no-results" tabindex="4">
                            <option value="line" selected="selected">线性图表</option>
                            <option value="column">柱型图表</option>
                            <option value="pie">饼型图表</option>
                        </select>
                    </div>

                    <div style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 40px;">
                        <em>X轴：</em>
                        <select id="xColumn" data-placeholder="" style="width:150px;" class="chosen-select-no-results" tabindex="5">
                            <option value="src">渠道</option>
                        </select>
                    </div>

                    <div style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 40px;">
                        <em>线性节点</em>
                        <select id="linedots" data-placeholder="" style="width:450px;" multiple class="chosen-select-no-results" tabindex="11">
                            <option value="get_ticket">索票量</option>
                            <option value="check_ticket">检票量</option>
                            <option value="check_ticket_person">验票人数</option>
                            <option value="order_count">订单总数</option>
                            <option value="order_person_count">下单人数</option>
                        </select>
                    </div>

                    <div style="min-width: 30px; max-width: 180px; height: 30px; margin-top: 40px; ">
                        <input type="button" value="show"  onclick="show()"/>
                    </div>
                </div>
            </div>
        </div>
        <script src="../plugins/chosen_v1.6.2/docsupport/jquery.min.js" type="text/javascript"></script>
        <script src="../plugins/chosen_v1.6.2/chosen.jquery.js" type="text/javascript"></script>
        <script src="../plugins/chosen_v1.6.2/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
            var config = {
                '.chosen-select'           : {},
                '.chosen-select-deselect'  : {allow_single_deselect:true},
                '.chosen-select-no-single' : {disable_search_threshold:10},
                '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
                '.chosen-select-width'     : {width:"65%"}
            }
            for (var selector in config) {
                $(selector).chosen(config[selector]);
            }
        </script>
    </form>
</div>

<div id="container" style="min-width: 310px; max-width: 900px; height: 360px; margin:0 auto"></div>

</body>
</html>