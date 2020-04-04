package com.example.demo.controller;

import com.example.demo.pojo.IMoocJSONResult;
import com.example.demo.pojo.UserSignin;
import com.example.demo.pojo.UserSigninSettingTable;
import com.example.demo.pojo.commen.CommonPage;
import com.example.demo.pojo.commen.CommonResult;
import com.example.demo.pojo.param.SignSettinParam;
import com.example.demo.pojo.param.UserSignParam;
import com.example.demo.service.SignService;
import com.example.demo.utils.TimeUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @ClassName SignController
 * @Description TODO
 * @Author liying
 * @Date 2020/4/4 12:25 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("mybatissign")
@Api(tags = "SignController", description = "打卡相关接口")
public class SignController {

    //int userid, double longitude, double latitude, int isInCircle, int shopid

    @Autowired
    private SignService signService;



    @Autowired
    private Sid sid;

    @ApiOperation("打卡信息上传")
    @RequestMapping(value = "/uploadSign",method = RequestMethod.POST)
    public IMoocJSONResult uploadSign(@RequestBody UserSignParam userSignParam) throws Exception {
        UserSignin userSignin = new UserSignin();
//        userSignin.setId(Long.valueOf(id));
        userSignin.setIsInCircle(userSignParam.getIsInCircle());
        userSignin.setLatitude(BigDecimal.valueOf(userSignParam.getLatitude()));
        userSignin.setLongitude(BigDecimal.valueOf(userSignParam.getLongitude()));
        userSignin.setShopid(Long.valueOf(userSignParam.getShopid()));
        userSignin.setSigninTime(TimeUtils.stringToDate(userSignParam.getSigninTime(),TimeUtils.formatYYmmDDHMSStr));
        userSignin.setUserid(Long.valueOf(userSignParam.getUserid()));

        signService.uploadSign(userSignin);
        return IMoocJSONResult.ok("打卡成功");
    }

    @ApiOperation("查询用户的打卡记录")
    @RequestMapping(value = "/querySignByUserId",method = RequestMethod.GET)
    public CommonResult<CommonPage<UserSignin>> querySignByUserId(String userId,String shopId,Integer page, Integer pageSize) {
        UserSignin userSignin = new UserSignin();
        userSignin.setUserid(Long.valueOf(userId));
        userSignin.setShopid(Long.valueOf(shopId));

        return CommonResult.success(CommonPage.restPage(signService.querySignByUserId(userSignin,page,pageSize)));
    }



    @ApiOperation("打卡半径，上下班时间设定")
    @RequestMapping(value = "/setRadius",method = RequestMethod.POST)
    public IMoocJSONResult setRadius(@RequestBody SignSettinParam signSettinParam) throws Exception {
        UserSigninSettingTable userSignin = new UserSigninSettingTable();
        userSignin.setRadius(signSettinParam.getRadius());
        userSignin.setLatitude(BigDecimal.valueOf(signSettinParam.getLatitude()));
        userSignin.setLongitude(BigDecimal.valueOf(signSettinParam.getLongitude()));
        userSignin.setShopid(Long.valueOf(signSettinParam.getShopid()));
        userSignin.setWorkoffTime(TimeUtils.stringToDate(signSettinParam.getWorkoffTime(),TimeUtils.formatYYmmDDHMSStr));
        userSignin.setWorkupTime(TimeUtils.stringToDate(signSettinParam.getWorkupTime(),TimeUtils.formatYYmmDDHMSStr));
        signService.setRadius(userSignin);
        return IMoocJSONResult.ok("设置成功");
    }

    @ApiOperation("打卡半径，上下班时间更新")
    @RequestMapping(value = "/updateRadius/{id}", method = RequestMethod.POST)
    public IMoocJSONResult updateRadius(@PathVariable("id") Long id, @Validated @RequestBody SignSettinParam signSettinParam) throws Exception {
        signService.updateRadius(id,signSettinParam.getRadius(),BigDecimal.valueOf(signSettinParam.getLatitude())
        ,BigDecimal.valueOf(signSettinParam.getLongitude())
                ,TimeUtils.stringToDate(signSettinParam.getWorkupTime(),TimeUtils.formatYYmmDDHMSStr)
                ,TimeUtils.stringToDate(signSettinParam.getWorkoffTime(),TimeUtils.formatYYmmDDHMSStr)
                ,Long.valueOf(signSettinParam.getShopid())
        );
        return IMoocJSONResult.ok("更新成功");
    }


    @ApiOperation("获取打卡半径，上下班时间")
    @RequestMapping(value = "/getRadiusByShopId",method = RequestMethod.GET)
    public CommonResult<UserSigninSettingTable> getRadius(int shopId){
        UserSigninSettingTable userSigninSettingTable = signService.getRadius(shopId);
        return CommonResult.success(userSigninSettingTable);
    }






}
