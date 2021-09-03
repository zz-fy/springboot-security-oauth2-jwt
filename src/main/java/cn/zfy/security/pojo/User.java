package cn.zfy.security.pojo;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Created by zfy
 */
@Data
@TableName("tb_user")
public class User extends BaseModel implements Serializable {


    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String username;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    @JsonIgnore
    private String password;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String phone;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String email;




}
