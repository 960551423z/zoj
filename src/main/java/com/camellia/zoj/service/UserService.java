package com.camellia.zoj.service;

import com.camellia.zoj.model.domain.User;
import com.camellia.zoj.model.dto.UserLoginDTO;
import com.camellia.zoj.model.dto.UserRegisterDTO;

import com.baomidou.mybatisplus.extension.service.IService;
import com.camellia.zoj.model.vo.UserLoginVO;

/**
* @author 96055
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2024-07-27 15:38:43
*/
public interface UserService extends IService<User> {

    void register(UserRegisterDTO userRegisterDTO);

    /**
     * 登录
     * @param userLoginDTO
     * @return
     */
    UserLoginVO login(UserLoginDTO userLoginDTO);
}
