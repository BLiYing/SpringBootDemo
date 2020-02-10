package com.example.demo.service.impl;

import com.example.demo.mapper.SysUserMapper;
import com.example.demo.mapper.SysUserMapperCustom;
import com.example.demo.pojo.SysUser;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.mysql.cj.log.Log;
import com.mysql.cj.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserMapper userMapper;

	/**
	 * 自定义sql语句查询
	 */
	@Autowired
	private SysUserMapperCustom sysUserMapperCustom;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUser(SysUser user) throws Exception {
		userMapper.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUser(SysUser user) {
        userMapper.updateByPrimaryKeySelective(user);
//        userMapper.updateByPrimaryKey(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(String userId) {
        userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public SysUser queryUserById(String userId) {

		/*try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SysUser> queryUserList(SysUser user) {

		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();

		if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
//			criteria.andEqualTo("username", user.getUsername());
			criteria.andLike("username", "%" + user.getUsername() + "%");
		}

		if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
			criteria.andLike("nickname", "%" + user.getNickname() + "%");
		}

		List<SysUser> userList = userMapper.selectByExample(example);

		return userList;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
		// 开始分页
		PageHelper.startPage(page, pageSize);

		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();

		if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
			criteria.andLike("nickname", "%" + user.getNickname() + "%");
		}
		example.orderBy("registTime").desc();
		List<SysUser> userList = userMapper.selectByExample(example);

		return userList;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public SysUser queryUserByIdCustom(String userId) {
		List<SysUser> userList = sysUserMapperCustom.queryUserSimplyInfoById(userId);

		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUserTransactional(SysUser user) {

		userMapper.insert(user);
//		user.setIsDelete(1);
		userMapper.updateByPrimaryKeySelective(user);
	}
	



}
