package com.cxd.entity.system;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    private String id;

    private String username;

    private String realname;

    private String password;

    private String salt;

    private String avatar;

    private Date birthday;

    private Boolean sex;

    private String email;

    private String phone;

    private String orgCode;

    private Boolean status;

    private Boolean delFlag;

    private String thirdId;

    private String thirdType;

    private Boolean activitiSync;

    private String workNo;

    private String post;

    private String telephone;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Boolean userIdentity;

    private String relTenantIds;

    private String clientId;

    private String departIds;

}