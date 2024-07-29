package com.camellia.zoj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.camellia.zoj.exception.BaseException;
import com.camellia.zoj.mapper.UserMapper;

import com.camellia.zoj.model.domain.User;
import com.camellia.zoj.model.dto.UserLoginDTO;
import com.camellia.zoj.model.dto.UserRegisterDTO;
import com.camellia.zoj.model.vo.UserLoginVO;
import com.camellia.zoj.service.UserService;
import com.camellia.zoj.utils.UserThreadLocal;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
* @author 96055
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2024-07-27 15:38:43
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{


    private static final String SALT = "camellia";

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        String userAccount = userRegisterDTO.getUserAccount();
        String userPassword = userRegisterDTO.getUserPassword();

        // 1. 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            throw new BaseException("参数为空");
        }
        if (userAccount.length() < 4) {
            throw new BaseException("用户账号过短");
        }
        if (userPassword.length() < 8 ) {
            throw new BaseException("用户密码过短");
        }

        synchronized (userAccount.intern()) {
            // 账户不能重复
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(User::getUserAccount, userAccount);
            long count = this.baseMapper.selectCount(queryWrapper);
            if (count > 0) {
                throw new BaseException("账号重复");
            }
            // 2. 加密
            String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
            // 3. 插入数据
            User user = new User();
            user.setUserAccount(userAccount);
            user.setUserPassword(encryptPassword);
            boolean saveResult = this.save(user);
            if (!saveResult) {
                throw new BaseException("注册失败，数据库错误");
            }
        }
    }

    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        String userAccount = userLoginDTO.getUserAccount();
        String userPassword = userLoginDTO.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            throw new BaseException("参数为空");
        }

        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserAccount, userAccount);
        wrapper.eq(User::getUserPassword, encryptPassword);

        User user = this.baseMapper.selectOne(wrapper);
        if (user == null) {
            return null;
        }
        UserLoginVO userLoginVO = BeanUtil.toBean(user, UserLoginVO.class);
        // todo：后期优化，在拦截器上进行设置
        String subject = JSON.toJSONString(userLoginVO);
        UserThreadLocal.saveString(subject);
        return userLoginVO;
    }
}




