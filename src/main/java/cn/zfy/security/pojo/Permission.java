package cn.zfy.security.pojo;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Created by zfy
 */
@Data
@TableName("tb_permission")
public class Permission implements Serializable {

    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String enname;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String url;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String description;
}
