package com.example.backend.service;

import com.example.backend.pojo.dto.ReturnResult;
import com.example.backend.pojo.query.UserLoginQuery;
import org.springframework.stereotype.Service;

/**
 * @author zhoutianlan
 * @since 2022/12/13
 */
@Service
public class UserService {
    private static final String ADMIN_ACCOUNT = "admin";
    private static final String ADMIN_PASSWORD = "12345678";

    public ReturnResult login(UserLoginQuery userLoginQuery) {
        if (ADMIN_ACCOUNT.equals(userLoginQuery.getAccount()) && ADMIN_PASSWORD.equals(userLoginQuery.getPassword()))
            return ReturnResult.getSuccessReturn("登录成功");
        else
            return ReturnResult.getFailureReturn("账号密码不正确");
    }
}
