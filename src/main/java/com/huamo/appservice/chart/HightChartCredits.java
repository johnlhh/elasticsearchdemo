package com.huamo.appservice.chart;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by luohh on 2016/10/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HightChartCredits {

    public HightChartCredits(){
        this.enabled = true;
        this.href = "http://www.51jiabo.com";
        this.text = "51jiabo.com";
        this.style = new HightChartStyle();
        this.position = new HightChartPosition();
    }

    private boolean enabled;

    private String href;

    private String text;

    private HightChartPosition position;

    private HightChartStyle style;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HightChartPosition getPosition() {
        return position;
    }

    public void setPosition(HightChartPosition position) {
        this.position = position;
    }

    public HightChartStyle getStyle() {
        return style;
    }

    public void setStyle(HightChartStyle style) {
        this.style = style;
    }
}
