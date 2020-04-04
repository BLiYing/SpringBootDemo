package com.example.demo.service.impl;

import com.example.demo.mapper.UserSigninMapper;
import com.example.demo.mapper.UserSigninSettingTableMapper;
import com.example.demo.pojo.UserSignin;
import com.example.demo.pojo.UserSigninSettingTable;
import com.example.demo.service.SignService;
import com.example.demo.utils.TimeUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SignServiceImpl
 * @Description TODO
 * @Author liying
 * @Date 2020/4/4 12:31 PM
 * @Version 1.0
 **/
@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private UserSigninMapper userSigninMapper;

    @Autowired
    private UserSigninSettingTableMapper userSigninSettingTableMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void uploadSign(UserSignin userSignin) {
        userSigninMapper.insert(userSignin);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<UserSignin> querySignByUserId(UserSignin userSignin, Integer page, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(page, pageSize);

        Example example = new Example(UserSignin.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(userSignin.getUserid() + "") && !StringUtils.isEmptyOrWhitespace(userSignin.getShopid() + "")) {
            criteria.andEqualTo("userid", userSignin.getUserid());
            criteria.andEqualTo("shopid", userSignin.getShopid());

        }
        //注意如果property有映射，则必须是实体申明的名称，而不是指数据库中该字段的名称signin_time
        example.orderBy("signinTime").desc();
        List<UserSignin> userList = userSigninMapper.selectByExample(example);
        return userList;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void setRadius(UserSigninSettingTable userSigninSettingTable) {
        if (userSigninSettingTable.getShopid() != null) {
            UserSigninSettingTable userSignin = getRadius(userSigninSettingTable.getShopid().intValue());
            if (userSignin != null && userSignin.getShopid() == userSigninSettingTable.getShopid()) {
                updateRadius(userSignin.getId(), userSigninSettingTable.getRadius(),userSigninSettingTable.getLatitude()
                        ,userSigninSettingTable.getLongitude(),userSigninSettingTable.getWorkupTime(),userSigninSettingTable.getWorkoffTime(),userSigninSettingTable.getShopid());
            } else {
                userSigninSettingTableMapper.insert(userSigninSettingTable);
            }
        }

    }

    @Override
    public void updateRadius(Long id, Integer radius, BigDecimal latitude, BigDecimal longitude, Date workupTime, Date workoffTime,Long shopId) {
        UserSigninSettingTable userSigninSettingTable = userSigninSettingTableMapper.selectByPrimaryKey(id);
        userSigninSettingTable.setRadius(radius);
        userSigninSettingTable.setLatitude(latitude);
        userSigninSettingTable.setLongitude(longitude);
        userSigninSettingTable.setWorkoffTime(workupTime);
        userSigninSettingTable.setWorkupTime(workoffTime);
        userSigninSettingTableMapper.updateByPrimaryKey(userSigninSettingTable);

    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserSigninSettingTable getRadius(int shopid) {
        UserSigninSettingTable userSigninSettingTable = new UserSigninSettingTable();
        userSigninSettingTable.setShopid(Long.valueOf(shopid));
        return userSigninSettingTableMapper.selectOne(userSigninSettingTable);
    }
}
