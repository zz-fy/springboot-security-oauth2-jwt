package cn.zfy.security.service.impl;

import cn.zfy.security.mapper.PermissionMapper;
import cn.zfy.security.pojo.Permission;
import cn.zfy.security.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Created by zfy
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements cn.zfy.security.service.PermissionService {
    @Override
    public List<Permission> queryByUserId(Long userId) {
        return this.getBaseMapper().queryByUserId(userId);
    }
}
