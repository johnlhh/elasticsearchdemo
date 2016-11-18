package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by luohh on 2016/10/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartPlotOptions {

    private HightChartPie pie;

    private HightChartColumn column;

    public HightChartPie getPie() {
        return pie;
    }

    public void setPie(HightChartPie pie) {
        this.pie = pie;
    }

    public HightChartColumn getColumn() {
        return column;
    }

    public void setColumn(HightChartColumn column) {
        this.column = column;
    }
}
