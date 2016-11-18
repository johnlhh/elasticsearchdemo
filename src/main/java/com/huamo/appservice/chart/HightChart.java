package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by luohh on 2016/10/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChart {


    private String plotBackgroundColor;

    private String plotBorderWidth;

    private boolean plotShadow;

    private String type;

    private String renderTo;

    private HightChartOptions3d options3d;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HightChartOptions3d getOptions3d() {
        return options3d;
    }

    public void setOptions3d(HightChartOptions3d options3d) {
        this.options3d = options3d;
    }

    public String getPlotBackgroundColor() {
        return plotBackgroundColor;
    }

    public void setPlotBackgroundColor(String plotBackgroundColor) {
        this.plotBackgroundColor = plotBackgroundColor;
    }

    public String getPlotBorderWidth() {
        return plotBorderWidth;
    }

    public void setPlotBorderWidth(String plotBorderWidth) {
        this.plotBorderWidth = plotBorderWidth;
    }

    public boolean isPlotShadow() {
        return plotShadow;
    }

    public void setPlotShadow(boolean plotShadow) {
        this.plotShadow = plotShadow;
    }

    public String getRenderTo() {
        return renderTo;
    }

    public void setRenderTo(String renderTo) {
        this.renderTo = renderTo;
    }
}
