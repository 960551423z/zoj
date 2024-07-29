package com.camellia.zoj.service;

import com.camellia.zoj.model.domain.Question;
import com.camellia.zoj.model.dto.question.QuestionAddDTO;
import com.camellia.zoj.model.dto.question.QuestionUpdateDTO;
import com.camellia.zoj.model.vo.question.QuestionVO;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 96055
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2024-07-27 15:39:13
*/
public interface QuestionService extends IService<Question> {

    /**
     * 增加题目
     * @param questionAddDTO 题目dto
     */
    Boolean addQuestion(QuestionAddDTO questionAddDTO);

    /**
     * 删除题目
     */
    Boolean delQuestion(Long questionId);

    /**
     * 得到题目
     */
    QuestionVO getQuestion(Long questionId);

    /**
     * 修改题目
     */
    Boolean updateQuestion(QuestionUpdateDTO questionUpdateDTO);
}
