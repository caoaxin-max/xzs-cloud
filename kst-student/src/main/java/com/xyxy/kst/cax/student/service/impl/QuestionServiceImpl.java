package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.entity.Question;
import com.xyxy.kst.cax.student.dao.QuestionDao;
import com.xyxy.kst.cax.student.service.QuestionService;
import org.springframework.stereotype.Service;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/13/14:57
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionDao, Question> implements QuestionService {
}
