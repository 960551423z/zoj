package com.camellia.zoj.utils;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.camellia.zoj.model.vo.UserLoginVO;
import lombok.Data;

/**
 * @author: 阿庆
 * @date: 2024/7/28 下午2:49
 */

@Data
public class UserThreadLocal {

    static ThreadLocal<String> userThreadLocal = new ThreadLocal<>();
    static ThreadLocal<Long> userThreadLocalByID = new ThreadLocal<>();


    /**
     * 存储对象字符串
     */
    public static void saveString(String value) {
        userThreadLocal.set(value);
    }


    /**
     * 获取对象字符串
     */
    public static String getString() {
        return userThreadLocal.get();
    }


    /**
     * 移除对象字符串
     */
    public static void removeString() {
        userThreadLocal.remove();
    }


    /**
     * 从当前线程中获取前端用户id
     * @return 用户id
     */
    public static Long getUserId() {
        String subject = userThreadLocal.get();
        UserLoginVO userLoginVO = JSON.parseObject(subject, UserLoginVO.class);
        return userLoginVO.getId();
    }

}
