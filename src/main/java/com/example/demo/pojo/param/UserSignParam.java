package com.example.demo.pojo.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserSignParam
 * @Description 打卡参数
 * @Author liying
 * @Date 2020/4/4 1:01 PM
 * @Version 1.0
 **/
public class UserSignParam {


    /**
     * 经度
     */
    private double longitude;

    /**
     * 纬度
     */
    private double latitude;

    /**
     * 用户id
     */
    private int userid;


    @ApiModelProperty(value = "打卡时间")
    private String signinTime;

    @ApiModelProperty(value = "是否在指定区域打卡；0->否；1->是")
    private int isInCircle;

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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(String signinTime) {
        this.signinTime = signinTime;
    }

    public int getIsInCircle() {
        return isInCircle;
    }

    public void setIsInCircle(int isInCircle) {
        this.isInCircle = isInCircle;
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }
}
