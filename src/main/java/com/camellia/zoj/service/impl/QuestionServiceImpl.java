package com.camellia.zoj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.camellia.zoj.common.HttpStatus;
import com.camellia.zoj.common.ResponseResult;
import com.camellia.zoj.exception.BaseException;
import com.camellia.zoj.mapper.QuestionMapper;

import com.camellia.zoj.model.domain.Question;
import com.camellia.zoj.model.dto.question.JudgeCase;
import com.camellia.zoj.model.dto.question.JudgeConfig;
import com.camellia.zoj.model.dto.question.QuestionAddDTO;
import com.camellia.zoj.model.dto.question.QuestionUpdateDTO;
import com.camellia.zoj.model.vo.question.QuestionVO;
import com.camellia.zoj.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 96055
 * @description 针对表【question(题目)】的数据库操作Service实现
 * @createDate 2024-07-27 15:39:13
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
        implements QuestionService {

    @Override
    public Boolean addQuestion(QuestionAddDTO questionAddDTO) {
        String title = questionAddDTO.getTitle();
        String content = questionAddDTO.getContent();

        if (title == null || title.length() > 100) {
            throw new BaseException("标题太长");
        }
        if (content == null || content.length() > 512) {
            throw new BaseException("内容太长");
        }

        List<JudgeCase> judgeCase = questionAddDTO.getJudgeCase();
        JudgeConfig judgeConfig = questionAddDTO.getJudgeConfig();
        List<String> tags = questionAddDTO.getTags();

        Question question = BeanUtil.toBean(questionAddDTO, Question.class);
        if (!CollectionUtil.isEmpty(tags)) {
            String tagStrings = JSON.toJSONString(tags);
            question.setTags(tagStrings);
        }
        if (!CollectionUtil.isEmpty(judgeCase)) {
            String judegeCaseString = JSON.toJSONString(judgeCase);
            question.setJudgeCase(judegeCaseString);
        }

        String judgeConfigString = JSON.toJSONString(judgeConfig);
        question.setJudgeConfig(judgeConfigString);
        // todo： 后期优化
        question.setUserId(0L);


        boolean flag = this.save(question);
        if (!flag) {
            throw new BaseException();
        }
        return true;
    }

    @Override
    public Boolean delQuestion(Long questionId) {
        boolean flag = this.removeById(questionId);
        if (!flag) {
            throw new BaseException();
        }
        return true;
    }

    @Override
    public QuestionVO getQuestion(Long questionId) {

        Question question = this.getById(questionId);
        if (question == null) {
            throw new BaseException(HttpStatus.QUERY_NOT_FIND.getCode(), HttpStatus.QUERY_NOT_FIND.getMessage());
        }

        String judgeCase = question.getJudgeCase();
        String tags = question.getTags();
        String judgeConfig = question.getJudgeConfig();

        QuestionVO questionVO = BeanUtil.copyProperties(question, QuestionVO.class,"judgeCase", "tags", "judgeConfig");
        questionVO.setJudgeCase(JSON.parseArray(judgeCase, JudgeCase.class));
        questionVO.setTags(JSON.parseArray(tags, String.class));
        questionVO.setJudgeConfig(JSON.parseObject(judgeConfig, JudgeConfig.class));
        return questionVO;
    }

    @Override
    public Boolean updateQuestion(QuestionUpdateDTO questionUpdateDTO) {
        Long id = questionUpdateDTO.getId();
        String title = questionUpdateDTO.getTitle();
        String content = questionUpdateDTO.getContent();

        if (id == null || id < 0) {
            throw new BaseException("ID 错误");
        }

        if (title == null || title.length() > 100) {
            throw new BaseException("标题太长");
        }

        if (content == null || content.length() > 512) {
            throw new BaseException("内容太长");
        }

        List<String> tags = questionUpdateDTO.getTags();
        List<JudgeCase> judgeCase = questionUpdateDTO.getJudgeCase();
        JudgeConfig judgeConfig = questionUpdateDTO.getJudgeConfig();

        Question question = BeanUtil.toBean(questionUpdateDTO, Question.class);
        if (!CollectionUtil.isEmpty(tags)) {
            String tagStrings = JSON.toJSONString(tags);
            question.setTags(tagStrings);
        }
        if (!CollectionUtil.isEmpty(judgeCase)) {
            String judegeCaseString = JSON.toJSONString(judgeCase);
            question.setJudgeCase(judegeCaseString);
        }

        String judgeConfigString = JSON.toJSONString(judgeConfig);
        question.setJudgeConfig(judgeConfigString);

        boolean flag = this.updateById(question);
        if (!flag)
            throw new BaseException();

        return true;
    }
}




