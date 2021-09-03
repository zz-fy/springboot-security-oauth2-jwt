package cn.zfy.security.service.impl;

import cn.zfy.security.mapper.UserMapper;
import cn.zfy.security.pojo.User;
import cn.zfy.security.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Created by zfy
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements cn.zfy.security.service.UserService {
    @Override
    public User getByUsername(String username) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username", username);
        return this.getBaseMapper().selectOne(query);
    }
}
