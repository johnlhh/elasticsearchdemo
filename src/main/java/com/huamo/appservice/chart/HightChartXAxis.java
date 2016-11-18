package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by luohh on 2016/10/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartXAxis {

    private List categories;

    public List getCategories() {
        return categories;
    }

    public void setCategories(List categories) {
        this.categories = categories;
    }
}
