package com.xyxy.kst.cax.remote;

import com.xyxy.kst.cax.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(contextId = "remoteGAExamPaper", value = "kst-service-admin")
public interface RemoteGAExamPaper {

    @PostMapping("api/admin/exam/paper/ga/{difficulty}/{subject}/{grade}/{numQuestions}/{username}")
    public Result gaExamPaper(@PathVariable("difficulty") int difficult,
                              @PathVariable("subject") int subject,
                              @PathVariable("grade") int grade,
                              @PathVariable("numQuestions") int numQuestions,
                              @PathVariable("username") String username);
}
