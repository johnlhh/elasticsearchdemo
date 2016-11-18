package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luohh on 2016/10/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartSeries {

    private String type;

    private String name;

    private List data;

    private String size;

    private String innerSize;

    private HightChartDataLabels dataLabels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public HightChartSeries(){
        data =  new ArrayList<>();
    }

    public void addData(Object value){
        data.add(value);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getInnerSize() {
        return innerSize;
    }

    public void setInnerSize(String innerSize) {
        this.innerSize = innerSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HightChartDataLabels getDataLabels() {
        return dataLabels;
    }

    public void setDataLabels(HightChartDataLabels dataLabels) {
        this.dataLabels = dataLabels;
    }
}
