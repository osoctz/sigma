package com.zone.auth.domain.agg;

import com.google.common.base.Preconditions;
import com.zone.auth.application.service.command.cmd.AccountChangeCommand;
import com.zone.auth.application.service.command.cmd.AccountCreateCommand;
import com.zone.auth.application.service.command.cmd.AccountUpdateCommand;
import com.zone.auth.shared.enums.AccountTypeEnum;
import com.zone.commons.entity.LoginUser;
import com.zone.commons.util.SecurityUtil;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: jianyong.zhu
 * @Date: 2022/1/21 11:47 上午
 * @Description: 账号聚合根
 */
@Data
@Accessors(chain = true)
public class AccountAgg {

  @ApiModelProperty(value = "主键")
  private Long id;

  @ApiModelProperty(value = "姓名")
  private String name;

  @ApiModelProperty(value = "手机号")
  private String phone;

  @ApiModelProperty(value = "密码，采用哈希算法进行单向加密")
  private String password;

  @ApiModelProperty(value = "1-超管 2-非超管")
  private AccountTypeEnum accountType;

  @ApiModelProperty(value = "邮箱")
  private String email;

  @ApiModelProperty(value = "角色id列表")
  private List<Long> roleIdList;

  @ApiModelProperty(value = "0-停用 1-正常")
  private Boolean status;

  @ApiModelProperty(value = "user_id")
  private Long createBy;

  @ApiModelProperty(value = "user_name")
  private String createName;

  @ApiModelProperty(value = "user_id")
  private Long updateBy;

  @ApiModelProperty(value = "user_name")
  private String updateName;


  /**
   * 新建一个 account
   */
  public static AccountAgg create(AccountCreateCommand createCommand, LoginUser loginUser) {
    return new AccountAgg()
        .setName(createCommand.getName())
        .setPhone(createCommand.getPhone())
        .setPassword(SecurityUtil.digestSha1(getDefaultPwd()))
        .setAccountType(AccountTypeEnum.NORMAL_USER)
        .setEmail(createCommand.getEmail())
        .setRoleIdList(createCommand.getRoleIdList())
        .setStatus(true)
        .setCreateBy(loginUser.getAccountId())
        .setCreateName(loginUser.getAccountName())
        .setUpdateBy(loginUser.getAccountId())
        .setUpdateName(loginUser.getAccountName());
  }

  /**
   * 获取默认密码
   */
  private static String getDefaultPwd() {
    return "123456";
  }

  /**
   * 更新账号
   */
  public void update(AccountUpdateCommand updateCommand, LoginUser loginUser) {
    this.setEmail(updateCommand.getEmail());
    this.setName(updateCommand.getName());
    this.setStatus(updateCommand.getStatus());
    this.setUpdateName(loginUser.getAccountName());
    this.setUpdateBy(loginUser.getAccountId());
  }

  /**
   * 修改个人信息
   */
  public void change(AccountChangeCommand changeCommand, LoginUser loginUser) {
    String oldPwd = SecurityUtil.digestSha1(SecurityUtil.rsaDecrypt(changeCommand.getOldPwd()));
    String newPwd = SecurityUtil.digestSha1(SecurityUtil.rsaDecrypt(changeCommand.getNewPwd()));

    Preconditions.checkState(this.getPassword().equals(oldPwd),"旧密码不正确");
    this.setPassword(newPwd);
    this.setName(changeCommand.getName());
    this.setEmail(changeCommand.getEmail());
    this.setUpdateName(loginUser.getAccountName());
    this.setUpdateBy(loginUser.getAccountId());
  }
}
