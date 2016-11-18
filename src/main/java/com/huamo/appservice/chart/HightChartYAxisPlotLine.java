package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by luohh on 2016/10/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartYAxisPlotLine{
    private int value;
    private int width;
    private String color;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
