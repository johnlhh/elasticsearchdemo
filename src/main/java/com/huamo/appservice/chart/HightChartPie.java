package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by luohh on 2016/10/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartPie {

    private boolean shadow;

    private List center;

    private boolean allowPointSelect;

    private String cursor;

    private HightChartDataLabels dataLabels;

    public boolean isAllowPointSelect() {
        return allowPointSelect;
    }

    public void setAllowPointSelect(boolean allowPointSelect) {
        this.allowPointSelect = allowPointSelect;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public HightChartDataLabels getDataLabels() {
        return dataLabels;
    }

    public void setDataLabels(HightChartDataLabels dataLabels) {
        this.dataLabels = dataLabels;
    }

    public boolean isShadow() {
        return shadow;
    }

    public void setShadow(boolean shadow) {
        this.shadow = shadow;
    }

    public List getCenter() {
        return center;
    }

    public void setCenter(List center) {
        this.center = center;
    }
}
