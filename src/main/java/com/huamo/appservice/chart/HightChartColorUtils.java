package com.huamo.appservice.chart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by luohh on 2016/10/20.
 */
public class HightChartColorUtils {

    public static List<String> getRandomColors(int n){
        List<String> colors = new ArrayList<>();
        for(int i = 0;i < n;i++){
            String color = getColor();
            while(colors.contains(color)){
                color = getColor();
            }
            colors.add(color);
        }
        return colors;
    }

    public static String getColor(){
        //红色
        String red;
        //绿色
        String green;
        //蓝色
        String blue;
        //生成随机对象
        Random random = new Random();
        //生成红色颜色代码
        red = Integer.toHexString(random.nextInt(256)).toUpperCase();
        //生成绿色颜色代码
        green = Integer.toHexString(random.nextInt(256)).toUpperCase();
        //生成蓝色颜色代码
        blue = Integer.toHexString(random.nextInt(256)).toUpperCase();

        //判断红色代码的位数
        red = red.length()==1 ? "0" + red : red ;
        //判断绿色代码的位数
        green = green.length()==1 ? "0" + green : green ;
        //判断蓝色代码的位数
        blue = blue.length()==1 ? "0" + blue : blue ;
        //生成十六进制颜色值
        String color = "#"+red+green+blue;
        return  color;
    }


    public static void main(String[] args)
    {

        List<String> colors = getRandomColors(12);
        for(int i = 0; i < colors.size(); i++){
            System.out.println(colors.get(i));
        }

    }
}
