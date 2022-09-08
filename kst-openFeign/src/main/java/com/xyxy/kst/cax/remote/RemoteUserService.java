package com.xyxy.kst.cax.remote;

import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "remoteUserService", value = "kst-service-admin")
public interface RemoteUserService {

    // 根据用户名称获取用户信息
    @GetMapping("/api/admin/getUserByUserName/{username}")
    public User getUserByUserName(@PathVariable("username") String username);


}
