package cn.zfy.security.service;

import cn.zfy.security.pojo.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description
 * @Created by zfy
 */
public interface PermissionService extends IService<Permission> {
    List<Permission> queryByUserId(Long userId);
}
