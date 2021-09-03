package cn.zfy.security.service;

import cn.zfy.security.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description
 * @Created by zfy
 */
public interface UserService extends IService<User> {

    User getByUsername(String username);

}
