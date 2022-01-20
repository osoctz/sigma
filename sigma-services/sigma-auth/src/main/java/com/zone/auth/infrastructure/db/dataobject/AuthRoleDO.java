package com.zone.auth.infrastructure.db.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Jone
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("auth_role")
@ApiModel(value="AuthRoleDO对象", description="角色表")
public class AuthRoleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色拥有的资源id，多个用,隔开")
    private String resources;

    @ApiModelProperty(value = "0-停用 1-正常")
    private Boolean status;

    @ApiModelProperty(value = "乐观锁版本")
    private Integer version;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "user_id")
    private Long createBy;

    @ApiModelProperty(value = "user_name")
    private String createName;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "user_id")
    private Long updateBy;

    @ApiModelProperty(value = "user_name")
    private String updateName;


}
