package com.camellia.zoj.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.camellia.zoj.model.domain.Question;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 96055
* @description 针对表【question(题目)】的数据库操作Mapper
* @createDate 2024-07-27 15:39:13
* @Entity generator.domain.Question
*/
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}




