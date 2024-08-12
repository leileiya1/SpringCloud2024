package com.sapiece.resp;

import lombok.Getter;

import java.util.Arrays;

/**
 * @Author SAPiece
 * @Create 2024-07-18 13:13
 * @Package com.sapiece.resp
 * @Project SpringCloud2024
 * @Filename ReturnCodeEnum
 * @Version 1.0
 */
@Getter
public enum ReturnCodeEnum {
    RC999("999", "操作异常"),
    RC200("200", "success"),
    RC201("201", "服务开启降级保护,请稍后重试!"),
    RC202("202", "热点参数限流,请稍后重试!"),
    RC203("203", "系统规则不满足要求,请稍后重试!"),
    RC204("204", "授权规则不通过,请稍后重试"),
    RC375("375", "请求频繁,请稍后重试!"),
    RC400("400", "请求参数错误"),
    RC401("401", "未授权的访问"),
    RC403("403", "禁止访问"),
    RC404("404", "资源不存在"),
    RC500("500", "服务器内部错误"),
    RC503("503", "服务不可用"),

    INVALID_TOKEN("2001", "无效的token"),

    ACCESS_DENIED("2003", "无访问权限"),

    CLIENT_AUTHENTICATION_FAILED("1001", "客户端认证失败"),

    USERNAME_OR_PASSWORD_FAILED("1002", "用户名或密码错误"),

    BUSINESS_EXCEPTION("1004", "业务异常"),

    UNSUPPORTED_GRANT_TYPE("1003", "不支持的grant_type");

    private final String code;
    private final String message;


    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ReturnCodeEnum getEum(String code) {
        return Arrays.stream(ReturnCodeEnum.values())
                .filter(x -> x.getCode().equalsIgnoreCase(code))
                .findFirst().orElse(null);
    }
}
