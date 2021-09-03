package cn.zfy.security.config;

import cn.zfy.security.pojo.Permission;
import cn.zfy.security.pojo.User;
import cn.zfy.security.service.PermissionService;
import cn.zfy.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserDetailsServiceImpl
 * @Description TODO
 * @Date 2020/10/14 15:28
 * @Created by zfy
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);
        if (user == null)
            return null;
        List<Permission> permissionList = permissionService.queryByUserId(user.getId());
        List<String> permissions = new ArrayList<>();
        if (permissionList != null && !permissionList.isEmpty())
            permissionList.stream().forEach(permission -> {
                permissions.add(permission.getEnname());
            });
        return new CustomUserDetails(user.getId(), username, user.getPassword(), user.getName(), user.getPhone(), permissions);
    }
}
