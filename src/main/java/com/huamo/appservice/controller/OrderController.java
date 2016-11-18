package com.huamo.appservice.controller;

import com.huamo.appservice.chart.*;
import com.huamo.appservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by luohh on 2016/10/18.
 */
@RestController
@RequestMapping(("/order/"))
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "v1.0/csto.do", method = RequestMethod.POST)
    public HightCharts getHomeBanners(HttpServletRequest request,
                                      HttpServletResponse response,
                                      @RequestParam(required = false) Integer city_id ,
                                      @RequestParam(required = false) Integer session
    ) throws  Exception{

        HightCharts hightCharts = new HightCharts();
        Map<String,Object> params = new HashMap<>();
        params.put("cityid",city_id);
        params.put("session", session);
        List<Map<String,Object>> result = orderService.getCitySessionTicketandOrder(params);

        HightChartTitle title = new HightChartTitle();
        title.setText("展会渠道索票和订单统计");
        title.setX(-20);

        hightCharts.setTitle(title);

        HightChartSubtitle subtitle = new HightChartSubtitle();
        subtitle.setText("上海--第"+session+"展会");
        subtitle.setX(-20);

        hightCharts.setSubtitle(subtitle);

        //x轴坐标设置
        HightChartXAxis xAxis = new HightChartXAxis();
        //xAxis.setCategories(getXcategory(monthOrderCount,"month"));
        List<String> xCategory = new ArrayList<String>();
        List<String> lineTypes = new ArrayList<String>();
        int i = 0;
        for(Map<String,Object> map : result){
            if(i++ == 0){
                for(String s :map.keySet()){
                    if(!"渠道".equals(s)){
                        lineTypes.add(s);
                    }
                }
            }
            xCategory.add((String) map.get("渠道"));
        }
        xAxis.setCategories(xCategory);

        hightCharts.setxAxis(xAxis);

        //y轴设置
        HightChartYAxis yAxis = new HightChartYAxis();

        HightChartYAxisTitle yAxisTitle = new HightChartYAxisTitle();
        yAxisTitle.setText("数量");

        List<HightChartYAxisPlotLine> plotLines = new ArrayList<>();

        HightChartYAxisPlotLine yAxisPlotLine = new HightChartYAxisPlotLine();
        yAxisPlotLine.setColor("#808080");
        yAxisPlotLine.setValue(0);
        yAxisPlotLine.setWidth(1);

        plotLines.add(yAxisPlotLine);

        yAxis.setTitle(yAxisTitle);
        yAxis.setPlotLines(plotLines);

        hightCharts.setyAxis(yAxis);

        HightChartTooltip tooltip = new HightChartTooltip();
        tooltip.setValueSuffix("个");

        hightCharts.setTooltip(tooltip);

        HightChartLegend legend = new HightChartLegend();
        legend.setAlign("right");
        legend.setVerticalAlign("middle");
        legend.setLayout("vertical");
        legend.setBorderWidth(0);

        hightCharts.setLegend(legend);


        List<HightChartSeries> series = new ArrayList<>();

        Map<String,HightChartSeries> resultTem = new HashMap<>();

        for(String s : xCategory){
            for(Map map : result){
                if(s.equals(map.get("渠道"))){
                    for(String s1 : lineTypes){
                        if(!resultTem.keySet().contains(s1)){
                            HightChartSeries seriesTemp = new HightChartSeries();
                            seriesTemp.setName(s1);
                            seriesTemp.addData(map.get(s1));
                            resultTem.put(s1,seriesTemp);
                        }else{
                            HightChartSeries seriesTemp = resultTem.get(s1);
                            seriesTemp.addData(map.get(s1));
                        }
                    }
                }
            }
        }
        Iterator iterator = resultTem.keySet().iterator();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            series.add(resultTem.get(key));
        }
        hightCharts.setSeries(series);


        HightChartCredits credits = new HightChartCredits();

        hightCharts.setCredits(credits);

       /* HightChart chart = new HightChart();
        chart.setType("");
        chart.setOptions3d(new HightChartOptions3d());
        hightCharts.setChart(chart);*/
        return hightCharts;
    }


    @RequestMapping(value = "v1.0/month_count.do", method = RequestMethod.POST)
    public HightCharts getHomeBanners(HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestParam(required = false) String year,
                                 @RequestParam(required = false) String showType
                                 ) throws  Exception{

        int[] orderTypes = {1,2,3,4,5};
        String[] xCategory = {"01","02","03","04","05","06","07","08","09","10","11","12"};

        if(year == null || "".equals(year)){
            year = new SimpleDateFormat("yyyy").format(new Date());
        }
        Map<String,Object> params = new HashMap<>();
        params.put("year", year);

         List<Map<String,Object>> monthOrderCount = orderService.getMonthsOrderCount(params);
        //HightCharts hightCharts = getHightChartsLine(year, showType, orderTypes, xCategory, monthOrderCount);
        HightCharts hightCharts = getHightChartsPie(xCategory,monthOrderCount);
        //HightCharts hightCharts = getHightChartsPiedonut(showType,xCategory,monthOrderCount);

        switch (showType){
            case "line": hightCharts = getHightChartsLine(year, showType, orderTypes, xCategory, monthOrderCount);break;
            case "pie" : hightCharts = getHightChartsPiedonut(showType, xCategory, monthOrderCount);break;
            case "column" : hightCharts = getHightCharts3DColumn(year, showType, orderTypes, xCategory, monthOrderCount);break;
        }
        return hightCharts;
    }


    /**
     * 基本饼图
     * @param xCategory
     * @param monthOrderCount
     * @return
     */
    public HightCharts getHightChartsPie(String[] xCategory,List<Map<String,Object>> monthOrderCount){

        HightCharts hightCharts = new HightCharts();

        HightChart chart = new HightChart();
        chart.setPlotBackgroundColor(null);
        chart.setPlotBorderWidth(null);
        chart.setPlotShadow(false);
        hightCharts.setChart(chart);

        HightChartTitle title = new HightChartTitle();
        title.setText("每月订单汇总报表");
        hightCharts.setTitle(title);

        HightChartTooltip tooltip = new HightChartTooltip();
        tooltip.setPointFormat("{series.name}: <b>{point.percentage:.1f}%</b>");
        hightCharts.setTooltip(tooltip);

        HightChartPlotOptions plotOptions = new HightChartPlotOptions();

        HightChartPie pie = new HightChartPie();
        pie.setAllowPointSelect(true);
        pie.setCursor("pointer");
        HightChartDataLabels dataLabels = new HightChartDataLabels();
        dataLabels.setEnabled(true);
        dataLabels.setFormat("<b>{point.name}</b>: {point.percentage:.1f} %");
        HightChartStyle style = new HightChartStyle();
        style.setColor("(Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'");
        dataLabels.setStyle(style);

        pie.setDataLabels(dataLabels);
        plotOptions.setPie(pie);

        hightCharts.setPlotOptions(plotOptions);

        Map<String,Long> xCategoryCount = new TreeMap<>();
        for(String x : xCategory){
            xCategoryCount.put(x,0l);
            for(Map<String,Object> map : monthOrderCount){
                if(x.equals(map.get("month"))){
                    Long count = xCategoryCount.get(x);
                    xCategoryCount.put(x,(Long)map.get ("count")+count);
                }
            }
        }

        List<HightChartSeries> seriesList = new ArrayList<>();

        HightChartSeries series = new HightChartSeries();
        series.setName("month order count");
        series.setType("pie");

        Iterator iterator = xCategoryCount.keySet().iterator();
        while(iterator.hasNext()){
            List<Object> list = new ArrayList<>();
            String key = (String) iterator.next();
            Long value = xCategoryCount.get(key);
            list.add(key+"月");
            list.add(value);
            series.addData(list);
        }
        seriesList.add(series);

        hightCharts.setSeries(seriesList);

        HightChartCredits credits = new HightChartCredits();

        hightCharts.setCredits(credits);

        return  hightCharts;
    }

    /**
     * 双拼图
     * @param xCategory
     * @param monthOrderCount
     * @return
     */
    public HightCharts getHightChartsPiedonut(String showType,String[] xCategory,List<Map<String,Object>> monthOrderCount){

        List<String> colors = HightChartColorUtils.getRandomColors(xCategory.length);

        HightCharts hightCharts = new HightCharts();

        HightChart chart = new HightChart();
        chart.setType(showType);
        //chart.setType("pie");
        hightCharts.setChart(chart);

        HightChartTitle title = new HightChartTitle();
        title.setText("每月订单汇总报表");
        hightCharts.setTitle(title);

        HightChartSubtitle subtitle = new HightChartSubtitle();
        subtitle.setText("2016");
        hightCharts.setSubtitle(subtitle);

        HightChartYAxis yAxis = new HightChartYAxis();
        HightChartYAxisTitle yAxisTitle = new HightChartYAxisTitle();
        yAxisTitle.setText("Total percent");


        HightChartTooltip tooltip = new HightChartTooltip();
        //tooltip.setValueSuffix("%");
        hightCharts.setTooltip(tooltip);

        HightChartPlotOptions plotOptions = new HightChartPlotOptions();

        HightChartPie pie = new HightChartPie();
        pie.setShadow(false);
        pie.setCenter(Arrays.asList(new String[]{"50%", "50%"}));
        plotOptions.setPie(pie);

        hightCharts.setPlotOptions(plotOptions);



        List<HightChartSeries> seriesList = new ArrayList<>();

        HightChartSeries seriesType = new HightChartSeries();
        seriesType.setName("每个月中订单类型所占个数");
        seriesType.setInnerSize("60%");
        seriesType.setSize("100%");

        HightChartDataLabels dataLabelsT = new HightChartDataLabels();
        dataLabelsT.setEnabled(true);
        dataLabelsT.setDistance(20);
        dataLabelsT.setFormat("<b>{point.name}</b>: {point.percentage:.1f} %");
        seriesType.setDataLabels(dataLabelsT);
        //dataLabelsT.setFormatter("function () {return this.y > 20 ? '<b>' + this.point.name + ':</b> ' + this.y + '%' : null;}");

        HightChartSeries seriesMonth = new HightChartSeries();
        seriesMonth.setSize("40%");
        seriesMonth.setName("每个月订单的总数");

        Map<String,Long> xCategoryCount = new TreeMap<>();
        int j = 0;
        for(String x : xCategory){

            xCategoryCount.put(x,0l);

            for(Map<String,Object> map : monthOrderCount){
                if(x.equals(map.get("month"))){
                    Long count = xCategoryCount.get(x);
                    xCategoryCount.put(x, (Long) map.get("count") + count);

                    Map<String,Object> maptype = new HashMap<>();
                    maptype.put("name",getOrderTypeName((Integer) map.get("order_type")));
                    maptype.put("y",(Long) map.get("count"));
                    maptype.put("color",colors.get(j));
                    seriesType.addData(maptype);
                }
            }
            j++;
        }

        int i=0;
        for(String key : xCategoryCount.keySet()){
            Long value = xCategoryCount.get(key);
            Map<String,Object> map = new HashMap<>();
            map.put("name", key);
            map.put("y",value);
            map.put("color",colors.get(i));
            seriesMonth.addData(map);
            i++;
        }

        HightChartDataLabels dataLabelsM = new HightChartDataLabels();

        dataLabelsM.setEnabled(true);
        dataLabelsM.setColor("#ffffff");
        dataLabelsM.setDistance(-10);
        dataLabelsM.setFormat("{point.name}月-{y}");
        //dataLabelsM.setFormatter("function () { return this.y > 50 ? this.point.name : null;}");

        seriesMonth.setDataLabels(dataLabelsM);

        seriesList.add(seriesMonth);
        seriesList.add(seriesType);
        hightCharts.setSeries(seriesList);

        HightChartCredits credits = new HightChartCredits();

        hightCharts.setCredits(credits);

        return  hightCharts;
    }

    public HightCharts getHightCharts3DColumn(String year,
                                             String showType,
                                             int[] orderTypes,
                                             String[] xCategory,
                                             List<Map<String, Object>> monthOrderCount){
        HightCharts hightCharts = new HightCharts();

        HightChart chart = new HightChart();
        chart.setPlotShadow(true);
        chart.setType("column");
        chart.setRenderTo("container");
        HightChartOptions3d options3d = new HightChartOptions3d();
        options3d.setEnabled(true);
        options3d.setAlpha(15);
        options3d.setBeta(15);
        options3d.setDepth(50);
        options3d.setViewDistance(25);
        chart.setOptions3d(options3d);
        hightCharts.setChart(chart);

        HightChartXAxis xAxis = new HightChartXAxis();
        xAxis.setCategories(Arrays.asList(xCategory));
        hightCharts.setxAxis(xAxis);

        HightChartTitle title = new HightChartTitle();
        title.setText("没月各种订单数量");
        hightCharts.setTitle(title);

        HightChartSubtitle subtitle = new HightChartSubtitle();
        subtitle.setText(year);
        hightCharts.setSubtitle(subtitle);

        HightChartPlotOptions plotOptions = new HightChartPlotOptions();

        HightChartColumn column = new HightChartColumn();
        column.setDepth(25);
        plotOptions.setColumn(column);
        hightCharts.setPlotOptions(plotOptions);

        List<HightChartSeries> series = new ArrayList<>();

        Map<String,HightChartSeries> resultTem = new HashMap<>();

        for(String s : xCategory){
            for(int type :orderTypes ){
                boolean isExist = false;
                for(Map map : monthOrderCount){
                    Integer ot = (Integer) map.get("order_type");
                    String month = (String) map.get("month");
                    String name = getOrderTypeName(ot);
                    if(ot.intValue() == type && s.equals(month)){
                        isExist = true;
                        if(!resultTem.keySet().contains(name)){
                            HightChartSeries seriesTemp = new HightChartSeries();
                            seriesTemp.setName(name);
                            seriesTemp.addData(map.get("count"));
                            resultTem.put(name,seriesTemp);
                        }else{
                            HightChartSeries seriesTemp = resultTem.get(name);
                            seriesTemp.addData( map.get("count"));
                        }
                        break;
                    }
                }
                if(!isExist){
                    String name = getOrderTypeName(type);
                    if(!resultTem.keySet().contains(name)){
                        HightChartSeries seriesTemp = new HightChartSeries();
                        seriesTemp.setName(name);
                        seriesTemp.addData(0);
                        resultTem.put(name,seriesTemp);
                    }else{
                        HightChartSeries seriesTemp = resultTem.get(name);
                        seriesTemp.addData(0);
                    }
                }
            }
        }
        Iterator iterator = resultTem.keySet().iterator();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            series.add(resultTem.get(key));
        }
        hightCharts.setSeries(series);


        HightChartCredits credits = new HightChartCredits();

        hightCharts.setCredits(credits);
        return  hightCharts;
    }

    /**
     * 线性图表结果
     * @param year
     * @param showType
     * @param orderTypes
     * @param xCategory
     * @param monthOrderCount
     * @return
     */
    public HightCharts getHightChartsLine(String year,
                                      String showType,
                                      int[] orderTypes,
                                      String[] xCategory,
                                      List<Map<String, Object>> monthOrderCount) {
        HightCharts hightCharts = new HightCharts();

        HightChartTitle title = new HightChartTitle();
        title.setText("月订单报表");
        title.setX(-20);

        hightCharts.setTitle(title);

        HightChartSubtitle subtitle = new HightChartSubtitle();
        subtitle.setText(year);
        subtitle.setX(-20);

        hightCharts.setSubtitle(subtitle);

        //x轴坐标设置
        HightChartXAxis xAxis = new HightChartXAxis();
        //xAxis.setCategories(getXcategory(monthOrderCount,"month"));
        xAxis.setCategories(Arrays.asList(xCategory));

        hightCharts.setxAxis(xAxis);

        //y轴设置
        HightChartYAxis yAxis = new HightChartYAxis();

        HightChartYAxisTitle yAxisTitle = new HightChartYAxisTitle();
        yAxisTitle.setText("count");

        List<HightChartYAxisPlotLine> plotLines = new ArrayList<>();

        HightChartYAxisPlotLine yAxisPlotLine = new HightChartYAxisPlotLine();
        yAxisPlotLine.setColor("#808080");
        yAxisPlotLine.setValue(0);
        yAxisPlotLine.setWidth(1);

        plotLines.add(yAxisPlotLine);

        yAxis.setTitle(yAxisTitle);
        yAxis.setPlotLines(plotLines);

        hightCharts.setyAxis(yAxis);

        HightChartTooltip tooltip = new HightChartTooltip();
        tooltip.setValueSuffix("个");

        hightCharts.setTooltip(tooltip);

        HightChartLegend legend = new HightChartLegend();
        legend.setAlign("right");
        legend.setVerticalAlign("middle");
        legend.setLayout("vertical");
        legend.setBorderWidth(0);

        hightCharts.setLegend(legend);


        List<HightChartSeries> series = new ArrayList<>();

        Map<String,HightChartSeries> resultTem = new HashMap<>();

        for(String s : xCategory){
            for(int type :orderTypes ){
                boolean isExist = false;
                for(Map map : monthOrderCount){
                    Integer ot = (Integer) map.get("order_type");
                    String month = (String) map.get("month");
                    String name = getOrderTypeName(ot);
                    if(ot.intValue() == type && s.equals(month)){
                        isExist = true;
                        if(!resultTem.keySet().contains(name)){
                            HightChartSeries seriesTemp = new HightChartSeries();
                            seriesTemp.setName(name);
                            seriesTemp.addData(map.get("count"));
                            resultTem.put(name,seriesTemp);
                        }else{
                            HightChartSeries seriesTemp = resultTem.get(name);
                            seriesTemp.addData( map.get("count"));
                        }
                        break;
                    }
                }
                if(!isExist){
                    String name = getOrderTypeName(type);
                    if(!resultTem.keySet().contains(name)){
                        HightChartSeries seriesTemp = new HightChartSeries();
                        seriesTemp.setName(name);
                        seriesTemp.addData(0);
                        resultTem.put(name,seriesTemp);
                    }else{
                        HightChartSeries seriesTemp = resultTem.get(name);
                        seriesTemp.addData(0);
                    }
                }
            }
        }
        Iterator iterator = resultTem.keySet().iterator();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            series.add(resultTem.get(key));
        }
        hightCharts.setSeries(series);


        HightChartCredits credits = new HightChartCredits();

        hightCharts.setCredits(credits);

        HightChart chart = new HightChart();
        chart.setType(showType);
        chart.setOptions3d(new HightChartOptions3d());

        hightCharts.setChart(chart);
        return hightCharts;
    }

    private String getOrderTypeName(int type){
        switch (type){
            case 1: return "订单类型1";
            case 2: return "订单类型2";
            case 3: return "订单类型3";
            case 4: return "订单类型4";
            case 5: return "订单类型5";
            default:return "异类";
        }
    }

    private List getXcategory(List<Map<String,Object>> monthOrderCount,String category){
        List result = new ArrayList();
        for(Map map : monthOrderCount){
            result.add(map.get(category));
        }
        return  result;
    }



}
