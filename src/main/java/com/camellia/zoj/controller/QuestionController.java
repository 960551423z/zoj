package com.camellia.zoj.controller;

import com.camellia.zoj.common.ResponseResult;
import com.camellia.zoj.exception.BaseException;
import com.camellia.zoj.model.dto.question.QuestionAddDTO;
import com.camellia.zoj.model.dto.question.QuestionUpdateDTO;
import com.camellia.zoj.model.vo.question.QuestionVO;
import com.camellia.zoj.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: 阿庆
 * @date: 2024/7/28 下午2:11
 * 题目相关controller
 */

@RestController
@RequestMapping("/question")
@Api(tags = "题目相关")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    // 增
    @PostMapping("/add")
    @ApiOperation("增加题目")
    public ResponseResult<Boolean> addQuestion(@RequestBody QuestionAddDTO questionAddDTO) {
        if (questionAddDTO == null)
            throw new BaseException("参数异常");

        Boolean flag = questionService.addQuestion(questionAddDTO);
        return ResponseResult.success(flag);
    }

    // 删
    @DeleteMapping("/delete/{questionId}")
    @ApiOperation("删除题目")
    public ResponseResult<Boolean> delQuestion(@PathVariable Long questionId) {
        if (questionId == null || questionId <= 0)
            throw new BaseException("参数异常");
        Boolean flag = questionService.delQuestion(questionId);
        return ResponseResult.success(flag);
    }

    // 改
    @PatchMapping("/update")
    @ApiOperation("修改题目")
    public ResponseResult<Boolean> updateQuestion(@RequestBody QuestionUpdateDTO questionUpdateDTO) {
        if (questionUpdateDTO == null)
            throw new BaseException("参数异常");
        Boolean flag = questionService.updateQuestion(questionUpdateDTO);
        return ResponseResult.success(flag);
    }


    // 查
    @GetMapping("/get/{questionId}")
    @ApiOperation("根据题目 id 查询题目")
    public ResponseResult<QuestionVO> getQuestion(@PathVariable Long questionId) {
        if (questionId == null || questionId <= 0)
            throw new BaseException("参数异常");
        QuestionVO questionVO = questionService.getQuestion(questionId);
        return ResponseResult.success(questionVO);
    }

}
