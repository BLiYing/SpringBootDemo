package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_signin_setting_table")
public class UserSigninSettingTable {
    @Id
    private Long id;

    /**
     * 店铺id
     */
    private Long shopid;

    /**
     * 打卡半径
     */
    private Integer radius;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 上班时间
     */
    @Column(name = "workup_time")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", locale="zh", timezone="GMT+8")
    private Date workupTime;

    /**
     * 下班时间
     */
    @Column(name = "workoff_time")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", locale="zh", timezone="GMT+8")
    private Date workoffTime;

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

    /**
     * 获取打卡半径
     *
     * @return radius - 打卡半径
     */
    public Integer getRadius() {
        return radius;
    }

    /**
     * 设置打卡半径
     *
     * @param radius 打卡半径
     */
    public void setRadius(Integer radius) {
        this.radius = radius;
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
     * 获取上班时间
     *
     * @return workup_time - 上班时间
     */
    public Date getWorkupTime() {
        return workupTime;
    }

    /**
     * 设置上班时间
     *
     * @param workupTime 上班时间
     */
    public void setWorkupTime(Date workupTime) {
        this.workupTime = workupTime;
    }

    /**
     * 获取下班时间
     *
     * @return workoff_time - 下班时间
     */
    public Date getWorkoffTime() {
        return workoffTime;
    }

    /**
     * 设置下班时间
     *
     * @param workoffTime 下班时间
     */
    public void setWorkoffTime(Date workoffTime) {
        this.workoffTime = workoffTime;
    }
}