package com.zone.process.application.service.command.cmd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @Author: jianyong.zhu
 * @Date: 2021/3/27 2:51 下午
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TaskOperateCommand {

    @ApiModelProperty("任务id")
    @NotBlank(message = "任务id不能为空")
    private String taskId;

    @ApiModelProperty("操作类型")
    @NotBlank(message = "操作类型不能为空")
    private String operationType;

    @ApiModelProperty("评论")
    private String comment;

    @ApiModelProperty("扩展字段")
    private String ext;

    @ApiModelProperty("表单数据")
    @NotNull(message = "表单数据不能为空")
    private Map<Long, Map<String, Object>> formDataMap;
}
