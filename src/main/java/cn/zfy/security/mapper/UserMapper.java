package cn.zfy.security.mapper;

import cn.zfy.security.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Created by zfy
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
