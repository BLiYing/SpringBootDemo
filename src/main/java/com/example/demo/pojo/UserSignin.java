package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_signin")
public class UserSignin {
    @Id
    private Long id;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 用户id
     */
    private Long userid;

    /**
     * 打卡时间
     */
    @Column(name = "signin_time")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", locale="zh", timezone="GMT+8")
    private Date signinTime;

    /**
     * 是否在指定区域打卡；0->否；1->是
     */
    @Column(name = "is_in_circle")
    private Integer isInCircle;

    /**
     * 店铺id
     */
    private Long shopid;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取纬度
     *
     * @return latitude - 纬度
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取用户id
     *
     * @return userid - 用户id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid 用户id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取打卡时间
     *
     * @return signin_time - 打卡时间
     */
    public Date getSigninTime() {
        return signinTime;
    }

    /**
     * 设置打卡时间
     *
     * @param signinTime 打卡时间
     */
    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }

    /**
     * 获取是否在指定区域打卡；0->否；1->是
     *
     * @return is_in_circle - 是否在指定区域打卡；0->否；1->是
     */
    public Integer getIsInCircle() {
        return isInCircle;
    }

    /**
     * 设置是否在指定区域打卡；0->否；1->是
     *
     * @param isInCircle 是否在指定区域打卡；0->否；1->是
     */
    public void setIsInCircle(Integer isInCircle) {
        this.isInCircle = isInCircle;
    }

    /**
     * 获取店铺id
     *
     * @return shopid - 店铺id
     */
    public Long getShopid() {
        return shopid;
    }

    /**
     * 设置店铺id
     *
     * @param shopid 店铺id
     */
    public void setShopid(Long shopid) {
        this.shopid = shopid;
    }
}