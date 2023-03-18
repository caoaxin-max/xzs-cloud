package com.xyxy.kst.cax.remote.admin;

import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.viewmodel.student.AnalyseFrom;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2023/3/13/17:22
 */
@FeignClient(contextId = "remoteExamPaperAnalyse", value = "kst-student")
public interface RemoteExamPaperAnalyse {

    @PostMapping("/api/student/exam/paper/analyse")
    public Result getAnalyse(@RequestBody AnalyseFrom analyse);
}
