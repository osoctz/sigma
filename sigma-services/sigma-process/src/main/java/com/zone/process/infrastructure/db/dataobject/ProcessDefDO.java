package com.zone.process.infrastructure.db.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 流程定义
 * </p>
 *
 * @author Jone
 * @since 2021-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("process_def")
@ApiModel(value="ProcessDefDO对象", description="流程定义")
public class ProcessDefDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "流程分类id")
    private String categoryId;

    @ApiModelProperty(value = "camunda中的流程定义id，关联到ACT_RE_PROCDEF")
    private String procDefId;

    @ApiModelProperty(value = "camunda中的流程定义key，关联到ACT_RE_PROCDEF的key")
    private String procDefKey;

    @ApiModelProperty(value = "camunda中的流程定义版本，关联到ACT_RE_PROCDEF的version")
    private Integer procDefVersion;

    @ApiModelProperty(value = "流程定义名称")
    private String name;

    @ApiModelProperty(value = "流程定义的状态，0-禁用 1-启用")
    private Boolean status;

    @ApiModelProperty(value = "当前流程的bpmn2.0的xml定义")
    private String bpmnXml;

    @ApiModelProperty(value = "当前流程定义下所关联的全部表单id, 用,隔开")
    private String formIds;

    @ApiModelProperty(value = "分类展示图标")
    private String iconUrl;

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
