package com.example.demo.pojo.param;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserSignParam
 * @Description 打卡参数
 * @Author liying
 * @Date 2020/4/4 1:01 PM
 * @Version 1.0
 **/
public class SignSettinParam {


    @ApiModelProperty(value = "经度")
    private double longitude;

    @ApiModelProperty(value = "纬度")
    private double latitude;

    @ApiModelProperty(value = "上班时间")
    private String workupTime;

    @ApiModelProperty(value = "下班时间")
    private String workoffTime;

    @ApiModelProperty(value = "打卡半径")
    private Integer radius;


    /**
     * 店铺id
     */
    private int shopid;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public String getWorkupTime() {
        return workupTime;
    }

    public void setWorkupTime(String workupTime) {
        this.workupTime = workupTime;
    }

    public String getWorkoffTime() {
        return workoffTime;
    }

    public void setWorkoffTime(String workoffTime) {
        this.workoffTime = workoffTime;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

}
