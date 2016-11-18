package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by luohh on 2016/10/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartTitle {

    private String text;

    private Integer x;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

}
