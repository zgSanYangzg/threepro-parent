package cn.three.module.security.model;

import java.util.Date;

/**
 * 登录记录表
 * Created by Administrator on 2018/1/30.
 */
public class LoginHistory {
    private String loginHistoryKey;//主键
    private String ssoSessionId;//缓存id token
    private String ssoUserName;//账户
    private String ssoSessionExpiration;//过期时间Long类型,经过字符处理存储
    private String ssoSessionStatus;//状态 Y N
    private Date ssoSessionCreation;//创建时间


    private String actionByProduct;//项目产品 wfj
    private String staffId;//人员id
    private String userType;//用户类型
    private String actionByIp;//ip


    private String companyId;
    private String companyType;


}
