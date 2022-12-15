package com.example.backend.pojo.query;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author zhoutianlan
 * @since 2022/12/13
 */
@Data
public class UserLoginQuery {
    @NotEmpty(message = "请输入账号")
    private String account;

    @NotEmpty(message = "请输入密码")
    private String password;
}
