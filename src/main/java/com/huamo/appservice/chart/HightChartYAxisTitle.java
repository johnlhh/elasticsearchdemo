package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by luohh on 2016/10/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartYAxisTitle {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
