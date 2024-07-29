package com.camellia.zoj.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 阿庆
 * @date: 2024/7/27 下午4:19
 */

@Data
public class UserLoginVO implements Serializable {


    private Long id;

    /**
     * 账号
     */
    private String userAccount;


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
