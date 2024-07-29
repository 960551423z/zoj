package com.camellia.zoj.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 阿庆
 * @date: 2024/7/27 下午4:03
 * 用户登录DTO
 */

@Data
public class UserLoginDTO implements Serializable {


    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

}
