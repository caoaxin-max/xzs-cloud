package com.xyxy.kst.cax.remote;

import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "remoteStudentRegister", value = "kst-student")
public interface RemoteStudentRegister {

    /**
     * 注册学生
     * @param user
     * @return
     */
    @PostMapping("/api/student/user/register")
    public Result userRegister(@RequestBody User user);
}
