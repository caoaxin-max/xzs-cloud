package com.xyxy.kst.cax;

import com.xyxy.kst.cax.dao.QuestionDao;
import com.xyxy.kst.cax.entity.Question;
import com.xyxy.kst.cax.service.ExamPaperService;
import com.xyxy.kst.cax.utils.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/14/10:20
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private ExamPaperService examPaperService;


    @Test
    public void test01() {
        int numQuestions = 5;
        int difficulty = 2;
        int subject = 6;
        int gradeLevel = 2;
        List<Question> questions = examPaperService.generatePaper(difficulty, numQuestions, subject, gradeLevel);
        System.out.println("==========================================");
        for (Question question : questions) {
            System.out.println(question);
        }
        System.out.println("==========================================");
    }
}
