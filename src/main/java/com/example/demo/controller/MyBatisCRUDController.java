package com.example.demo.controller;

import com.example.demo.pojo.IMoocJSONResult;
import com.example.demo.pojo.PageInfoBase;
import com.example.demo.pojo.SysUser;
import com.example.demo.pojo.SysUserParam;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;


	
	@Autowired
	private Sid sid;
	
	@RequestMapping(value = "/saveUser",method = RequestMethod.POST)
	public IMoocJSONResult saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("zhangsan " + new Date());
		user.setNickname("zhangsan " + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return IMoocJSONResult.ok("saveUser 保存成功");
	}
	
	@RequestMapping(value = "/updateUser",method = RequestMethod.POST)
	public IMoocJSONResult updateUser(@RequestParam(name = "username",required = true)String username,
									  @RequestParam(name = "password")String password) {
		
		SysUser user = new SysUser();
		user.setId("10011001");
		user.setUsername(username);
		user.setPassword(password);
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return IMoocJSONResult.ok("更新成功");
	}

	@RequestMapping(value = "/updateUserByRequestBody",method = RequestMethod.POST)
	public IMoocJSONResult updateUserByRequestBody(@RequestBody SysUserParam sysUserParam) {
		SysUser user = new SysUser();
		user.setId("10011001");
		user.setUsername(sysUserParam.getUsername());
		user.setPassword(sysUserParam.getPassword());
		user.setIsDelete(0);
		user.setRegistTime(new Date());

		userService.updateUser(user);

		return IMoocJSONResult.ok("更新成功");
	}
	
	@RequestMapping(value = "/deleteUser/{userId}",method = RequestMethod.DELETE)
	public IMoocJSONResult deleteUser(@PathVariable String userId) {
		
		userService.deleteUser(userId);
		
		return IMoocJSONResult.ok("删除成功");
	}
	
	@RequestMapping(value = "/queryUserById",method = RequestMethod.POST)
	public IMoocJSONResult queryUserById(String userId) {
		
		return IMoocJSONResult.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping(value = "/queryUserList",method = RequestMethod.POST)
	public IMoocJSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("imooc");
		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return IMoocJSONResult.ok(userList);
	}
	
	@RequestMapping(value = "/queryUserListPaged/{page}",method = RequestMethod.POST)
	public IMoocJSONResult queryUserListPaged(@PathVariable Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 10;
		
		SysUser user = new SysUser();
//		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
//		PageInfoBase<SysUser> pageInfo = new PageInfoBase<>(userList);
		PageInfo<SysUser> pageInfo = new PageInfo<>(userList);

		return IMoocJSONResult.ok(pageInfo);
	}
	
	@RequestMapping(value = "/queryUserByIdCustom",method = RequestMethod.POST)
	public IMoocJSONResult queryUserByIdCustom(String userId) {
		
		return IMoocJSONResult.ok(userService.queryUserByIdCustom(userId));
	}
	
	@RequestMapping(value = "/saveUserTransactional",method = RequestMethod.POST)
	public IMoocJSONResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("lee " + new Date());
		user.setNickname("lee " + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return IMoocJSONResult.ok("saveUserTransactional 保存成功");
	}
}
