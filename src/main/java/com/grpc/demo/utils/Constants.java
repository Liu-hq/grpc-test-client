package com.grpc.demo.utils;

/**
 * Description: 常量类
 * Author: wzl
 * Version: 1.0
 * Create Date Time: 2018/10/17 11:19.
 *
 * @see
 */
public class Constants {

    /**response code start**/
    public static final int VERIFICATION_FAILURE_CODE = 1001;// 验证码失效
    public static final int VERIFICATION_ERROR_CODE = 1002;// 验证码错误
    public static final int SUCCESS_CODE = 2000;// 成功状态码
    public static final int FAIL_CODE = 2001;// 失败状态码
    public static final int INVOKE_SUCCESS_CODE = 2002;// 远程服务调用失败状态码
    public static final int INVOKE_FAIL_CODE = 2003;// 远程服务调用失败状态码
    public static final int EXCEPTION_CODE = 2005;// 异常状态码
    public static final int NO_ACCOUNT_CODE = 2007;//账户不存在状态码
    public static final int ACCOUNT_DISABLED_CODE = 2008;// 账户禁用状态码
    public static final int LOGIN_SUCCESS_CODE = 2010;//登录成功
    public static final int LOGIN_FAIL_CODE = 2011;//登录失败
    public static final String SUCCESS_MSG = "操作成功";// 成功消息
    public static final String FAIL_MSG = "操作失败";
    /**response code end**/

    /**redis key name start**/
    public static final String TENANTID_COOKIE="TENANT_ID";
    public static final String TOKEN_COOKIE="TOKEN";
    public static final String TOKEN_HEADER="TOKEN";
    public static final String AUTH = "auth:";
    public static final String AUTH_LOGIN_TOKEN = AUTH + "loginToken";
    public static final String AUTH_LOGIN_USER_INFO = AUTH + "loginUserInfo";
    public static final String SHARE_SCHEME_GROUP = "shareSchemeGroup";
    public static final String COMPANY_SHARE_SCHEME_GROUP = "companyShareSchemeGroup";
    public static final String SEQUENCE_KEY = "sequenceKey";//流水号code的key
    /**redis key name end**/
    public static long BaseNumber = 1;//递增1
}
