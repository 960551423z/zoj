package com.camellia.zoj.controller;

import com.camellia.zoj.common.ResponseResult;
import com.camellia.zoj.exception.BaseException;
import com.camellia.zoj.model.dto.UserLoginDTO;
import com.camellia.zoj.model.dto.UserRegisterDTO;
import com.camellia.zoj.model.vo.UserLoginVO;
import com.camellia.zoj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 阿庆
 * @date: 2024/7/27 下午3:47
 */

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseResult register(@RequestBody UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO == null)
            throw new BaseException("请求参数错误");

        userService.register(userRegisterDTO);
        return ResponseResult.success();
    }


    @PostMapping("/login")
    public ResponseResult login(@RequestBody UserLoginDTO userLoginDTO){
        if (userLoginDTO == null)
            throw new BaseException("请求参数错误");
        UserLoginVO userLoginVo = userService.login(userLoginDTO);
        return ResponseResult.success(userLoginVo);
    }
}
