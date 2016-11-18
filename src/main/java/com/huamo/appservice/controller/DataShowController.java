package com.huamo.appservice.controller;

import com.huamo.appservice.chart.*;
import com.huamo.appservice.service.DataShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by luohh on 2016/10/24.
 */
@RestController
@RequestMapping("/data/show/")
public class DataShowController {

    @Autowired
    private DataShowService dataShowService;

    @RequestMapping(value = "v1.0/src_list.do", method = RequestMethod.POST)
    public List<String> getSrcList(HttpServletRequest request,
                                      HttpServletResponse response,
                                      @RequestParam(required = true) Integer city_id
    ) throws  Exception{
        return dataShowService.getCitySrcs(city_id);
    }

    @RequestMapping(value = "v1.0/session_list.do", method = RequestMethod.POST)
    public List<Integer> getSessionList(HttpServletRequest request,
                                       HttpServletResponse response,
                                       @RequestParam(required = true) Integer city_id
    ) throws  Exception{
        return dataShowService.getCitySessions(city_id);
    }

    @RequestMapping(value = "v1.0/city_session_summary.do", method = RequestMethod.POST)
    public HightCharts getHomeBanners(HttpServletRequest request,
                                  HttpServletResponse response,
                                  @RequestParam(required = true) String title,
                                  @RequestParam(required = true) String subTitle,
                                  @RequestParam(required = true) Integer city_id,
                                  @RequestParam(required = true) Integer session,
                                  @RequestParam(required = false)String showType,
                                  @RequestParam(required = false)String xColumn,
                                  @RequestParam(required = false)String xColumnValues,
                                  @RequestParam(required = false)String lineTypesStr,
                                  @RequestParam(required = false,defaultValue = "0")Integer orderType,
                                  @RequestParam(required = false,defaultValue = "10")Integer limit
    ) throws  Exception{

        Map<String,Object> params = new HashMap<>();
        params.put("cityid",city_id);
        params.put("session", session);
        params.put("orderType", orderType);
        params.put("limit", limit);

        List<String> columnList = new ArrayList<>();
        //List<String> columnList = Arrays.asList(lineTypesStr.split(","));
        if(lineTypesStr != null && !"".equals(lineTypesStr)){
            for(String s :lineTypesStr.split(",") ){
                columnList.add(s);
            }
        }
        columnList.add(xColumn);
        params.put("columnList", columnList);
        List<Map<String,Object>> result = dataShowService.getCitySessionSummary(params);

        List xCategory = new ArrayList();
        List<String> lineTypes = Arrays.asList(lineTypesStr.split(","));

        for(Map<String,Object> map : result){
            xCategory.add(map.get(xColumn));
        }
        if("pie".equals(showType)){
            return getHightChartsPiedonut(title,subTitle,"各渠道数量汇总","每个渠道数量",xColumn, xCategory, lineTypes,result);
        }else{
            return getHightChartsLineOrColumn(title, subTitle, showType, xColumn, result, xCategory, lineTypes);
        }
    }


    @RequestMapping(value = "v1.0/city_src_summary.do", method = RequestMethod.POST)
    public HightCharts getHomeBannsdf(HttpServletRequest request,
                                      HttpServletResponse response,
                                      @RequestParam(required = true) String title,
                                      @RequestParam(required = true) String subTitle,
                                      @RequestParam(required = true) Integer city_id,
                                      @RequestParam(required = true) String src ,
                                      @RequestParam(required = false)String showType,
                                      @RequestParam(required = false)String xColumn,
                                      @RequestParam(required = false)String xColumnValues,
                                      @RequestParam(required = false)String lineTypesStr,
                                      @RequestParam(required = false,defaultValue = "0")Integer orderType,
                                      @RequestParam(required = false,defaultValue = "10")Integer limit
    ) throws  Exception{
        Map<String,Object> params = new HashMap<>();
        params.put("city_id",city_id);
        params.put("src", src);
        params.put("orderType", orderType);
        params.put("limit", limit);
        List<String> columnList = new ArrayList<>();
        if(lineTypesStr != null && !"".equals(lineTypesStr)){
            for(String s :lineTypesStr.split(",") ){
                columnList.add(s);
            }
        }
        columnList.add(xColumn);
        params.put("columnList", columnList);
        List<Map<String,Object>> result = dataShowService.getSrcdatabySessions(params);

        List xCategory = new ArrayList();
        List<String> lineTypes = Arrays.asList(lineTypesStr.split(","));

        for(Map<String,Object> map : result){
            xCategory.add( map.get(xColumn));
        }
        if("pie".equals(showType)){
            return getHightChartsPiedonut(title,subTitle,"各渠道数量汇总","每个渠道数量",xColumn, xCategory, lineTypes,result);
        }else{
            return getHightChartsLineOrColumn(title, subTitle, showType, xColumn, result, xCategory, lineTypes);
        }
    }

    /**
     * 获取线性或柱型
     * @param title
     * @param subTitle
     * @param showType
     * @param xColumn
     * @param result
     * @param xCategory
     * @param lineTypes
     * @return
     */
    public HightCharts getHightChartsLineOrColumn(String title,String subTitle, String showType,String xColumn, List<Map<String, Object>> result, List<String> xCategory, List<String> lineTypes) {
        HightCharts hightCharts = new HightCharts();
        HightChartTitle mytitle = new HightChartTitle();
        mytitle.setText(title);
        mytitle.setX(-20);

        hightCharts.setTitle(mytitle);

        HightChartSubtitle subtitle = new HightChartSubtitle();
        subtitle.setText(subTitle);
        subtitle.setX(-20);

        hightCharts.setSubtitle(subtitle);

        //x轴坐标设置
        HightChartXAxis xAxis = new HightChartXAxis();
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

        for(Object s : xCategory){
            for(Map map : result){
                if(s.equals(map.get(xColumn))){
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

        HightChart chart = new HightChart();
        chart.setType(showType);
        if("column".equals(showType)){
            chart.setOptions3d(new HightChartOptions3d());
        }
        hightCharts.setChart(chart);
        return hightCharts;
    }


    /**
     * 双拼图
     * @param xCategory
     * @param result
     * @return
     */
    public HightCharts getHightChartsPiedonut(String title,String subTitle,
                                              String momTitle,String sonTitle,
                                              String xColumn, List xCategory, List<String> lineTypes,
                                              List<Map<String,Object>> result){
        List<String> colors = HightChartColorUtils.getRandomColors(xCategory.size());
        HightCharts hightCharts = new HightCharts();
        HightChart chart = new HightChart();
        chart.setType("pie");
        hightCharts.setChart(chart);

        HightChartTitle mytitle = new HightChartTitle();
        mytitle.setText(title);
        hightCharts.setTitle(mytitle);

        HightChartSubtitle subtitle = new HightChartSubtitle();
        subtitle.setText(subTitle);
        hightCharts.setSubtitle(subtitle);

        HightChartYAxis yAxis = new HightChartYAxis();
        HightChartYAxisTitle yAxisTitle = new HightChartYAxisTitle();
        yAxisTitle.setText("");


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

        HightChartSeries seriesSon = new HightChartSeries();
        seriesSon.setName(sonTitle);
        seriesSon.setInnerSize("60%");
        seriesSon.setSize("100%");

        HightChartDataLabels dataLabelsSon = new HightChartDataLabels();
        dataLabelsSon.setEnabled(true);
        dataLabelsSon.setDistance(20);
        dataLabelsSon.setFormat("<b>{point.name}</b>: {point.percentage:.1f} %");
        seriesSon.setDataLabels(dataLabelsSon);

        HightChartSeries seriesMom = new HightChartSeries();
        seriesMom.setSize("40%");
        seriesMom.setName(momTitle);

        Map<Object,Integer> xCategoryCount = new TreeMap<>();
        int j = 0;
        for(Object x : xCategory){
            xCategoryCount.put(x,0);
            for(Map<String,Object> map : result){
                if(x.equals(map.get(xColumn))){
                    for(String s : lineTypes){
                        Integer count = xCategoryCount.get(x);
                        xCategoryCount.put(x, (Integer) map.get(s) + count);
                        Map<String,Object> maptype = new HashMap<>();
                        maptype.put("name",s);
                        maptype.put("y",(Integer) map.get(s));
                        maptype.put("color",colors.get(j));
                        seriesSon.addData(maptype);
                    }
                }
            }
            j++;
        }

        int i=0;
        for(Object key : xCategoryCount.keySet()){
            Integer value = xCategoryCount.get(key);
            Map<String,Object> map = new HashMap<>();
            map.put("name", key);
            map.put("y",value);
            map.put("color",colors.get(i));
            seriesMom.addData(map);
            i++;
        }

        HightChartDataLabels dataLabelsM = new HightChartDataLabels();

        dataLabelsM.setEnabled(true);
        dataLabelsM.setColor("#ffffff");
        dataLabelsM.setDistance(-10);
        seriesMom.setDataLabels(dataLabelsM);
        seriesList.add(seriesMom);
        seriesList.add(seriesSon);
        hightCharts.setSeries(seriesList);
        HightChartCredits credits = new HightChartCredits();
        hightCharts.setCredits(credits);

        return  hightCharts;
    }




}
