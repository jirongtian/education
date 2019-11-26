package com.ntyx.vedu.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ntyx.vedu.entity.User;
import com.ntyx.vedu.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger( UserService.class);


    @Autowired
    private UserMapper userMapper;

    public User findByEmail(String email) {
        LOGGER.info("根据email查询用户");
        return userMapper.findByEmail(email);
    }

    public PageInfo findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page , pageSize);//分页
        LOGGER.info("执行查询全部user操作");
        List<User> list = userMapper.findAll();
        return new PageInfo(list);
    }

    public void save(User user) {
        user.setCreateTime(new Date());
        userMapper.save(user);
        LOGGER.info("保存user成功");
    }

    public void update(User user) {
        userMapper.update(user);
        LOGGER.info("修改用户成功");
    }

    public void delete(Integer id) {
        userMapper.deleteById(id);
        LOGGER.info("根据id删除用户成功");
    }


    public User findById(Integer id) {
        LOGGER.info("根据id查询用户user");
        return userMapper.findById(id);
    }

}
