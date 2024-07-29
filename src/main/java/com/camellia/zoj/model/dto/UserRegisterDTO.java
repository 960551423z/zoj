package com.camellia.zoj.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: 阿庆
 * @date: 2024/7/27 下午4:03
 * 用户注册DTO
 */

@Data
public class UserRegisterDTO implements Serializable {


    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 微信开放平台id
     */
    private String unionId;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

}
