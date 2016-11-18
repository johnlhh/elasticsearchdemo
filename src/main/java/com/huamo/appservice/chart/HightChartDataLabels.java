package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by luohh on 2016/10/20.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartDataLabels {
    private boolean enabled;

    private String format;

    private String formatter;

    private HightChartStyle style;

    private String color;

    private int distance;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public HightChartStyle getStyle() {
        return style;
    }

    public void setStyle(HightChartStyle style) {
        this.style = style;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

