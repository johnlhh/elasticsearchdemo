package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

/**
 * Created by luohh on 2016/10/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartYAxis {

    private HightChartYAxisTitle title;

    private List<HightChartYAxisPlotLine> plotLines;


    public HightChartYAxisTitle getTitle() {
        return title;
    }

    public void setTitle(HightChartYAxisTitle title) {
        this.title = title;
    }

    public List<HightChartYAxisPlotLine> getPlotLines() {
        return plotLines;
    }

    public void setPlotLines(List<HightChartYAxisPlotLine> plotLines) {
        this.plotLines = plotLines;
    }








}
