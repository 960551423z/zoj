package com.camellia.zoj.model.vo.question;

import com.camellia.zoj.model.dto.question.JudgeCase;
import com.camellia.zoj.model.dto.question.JudgeConfig;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: 阿庆
 * @date: 2024/7/28 下午3:11
 */

@Data
public class QuestionVO implements Serializable {

    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表
     */
    private List<String> tags;


    /**
     * 题目提交数
     */
    private Integer submitNum;

    /**
     * 题目通过数
     */
    private Integer acceptedNum;

    /**
     * 判题用例（json 数组）
     */
    private List<JudgeCase> judgeCase;


    /**
     * 判题配置（json 对象）
     */
    private JudgeConfig judgeConfig;


    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
