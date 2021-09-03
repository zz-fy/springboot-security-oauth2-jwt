package cn.zfy.security.service.impl;

import cn.zfy.security.mapper.RoleMapper;
import cn.zfy.security.pojo.Role;
import cn.zfy.security.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Created by zfy
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
