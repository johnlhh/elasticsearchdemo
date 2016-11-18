package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by luohh on 2016/10/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartStyle {

    public HightChartStyle(){
        this.cursor = "pointer";
        this.color = "#909090";
        this.fontSize = "10px";
    }

    private String cursor ;

    private String color;

    private String fontSize;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }
}
