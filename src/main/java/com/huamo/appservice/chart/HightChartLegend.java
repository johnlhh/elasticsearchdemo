package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by luohh on 2016/10/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartLegend {

    private String layout;
    private String align;
    private String verticalAlign;
    private int borderWidth;

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getVerticalAlign() {
        return verticalAlign;
    }

    public void setVerticalAlign(String verticalAlign) {
        this.verticalAlign = verticalAlign;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }
}
