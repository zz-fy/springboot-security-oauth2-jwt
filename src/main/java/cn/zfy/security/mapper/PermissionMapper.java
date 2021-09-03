package cn.zfy.security.mapper;

import cn.zfy.security.pojo.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description
 * @Created by zfy
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> queryByUserId(@Param("userId") Long userId);
}
