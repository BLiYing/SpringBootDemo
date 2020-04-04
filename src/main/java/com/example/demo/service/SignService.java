package com.example.demo.service;

import com.example.demo.pojo.UserSignin;
import com.example.demo.pojo.UserSigninSettingTable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface SignService {
    public void uploadSign(UserSignin userSignin);

    public List<UserSignin> querySignByUserId(UserSignin userSignin, Integer page, Integer pageSize);

    public void setRadius(UserSigninSettingTable userSigninSettingTable);
    public void updateRadius(Long id, Integer radius, BigDecimal latitude, BigDecimal longitude, Date workupTime, Date workoffTime,Long shopId);

    public UserSigninSettingTable getRadius(int shopid);

}
