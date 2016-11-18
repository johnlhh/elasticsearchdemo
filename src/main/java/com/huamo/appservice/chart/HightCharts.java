package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by luohh on 2016/10/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightCharts {

    private HightChart chart;

    private HightChartTitle title;

    private HightChartSubtitle subtitle;

    private HightChartXAxis xAxis;

    private HightChartYAxis yAxis;

    private HightChartTooltip tooltip;

    private HightChartLegend legend;

    private HightChartCredits credits;

    private List<HightChartSeries> series;

    private HightChartPlotOptions plotOptions;

    public HightChartPlotOptions getPlotOptions() {
        return plotOptions;
    }

    public void setPlotOptions(HightChartPlotOptions plotOptions) {
        this.plotOptions = plotOptions;
    }

    public HightChartTitle getTitle() {
        return title;
    }

    public void setTitle(HightChartTitle title) {
        this.title = title;
    }

    public HightChartSubtitle getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(HightChartSubtitle subtitle) {
        this.subtitle = subtitle;
    }

    public HightChartXAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(HightChartXAxis xAxis) {
        this.xAxis = xAxis;
    }

    public HightChartYAxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(HightChartYAxis yAxis) {
        this.yAxis = yAxis;
    }

    public HightChartTooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(HightChartTooltip tooltip) {
        this.tooltip = tooltip;
    }

    public HightChartLegend getLegend() {
        return legend;
    }

    public void setLegend(HightChartLegend legend) {
        this.legend = legend;
    }

    public List<HightChartSeries> getSeries() {
        return series;
    }

    public void setSeries(List<HightChartSeries> series) {
        this.series = series;
    }

    public HightChartCredits getCredits() {
        return credits;
    }

    public void setCredits(HightChartCredits credits) {
        this.credits = credits;
    }

    public HightChart getChart() {
        return chart;
    }

    public void setChart(HightChart chart) {
        this.chart = chart;
    }
}
