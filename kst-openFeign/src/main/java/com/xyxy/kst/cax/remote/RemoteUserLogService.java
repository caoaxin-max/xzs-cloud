package com.xyxy.kst.cax.remote;

import com.xyxy.kst.cax.entity.UserEventLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "remoteUserLogService", value = "kst-service-admin")
public interface RemoteUserLogService {
    @PostMapping("/api/admin/saveUserEventLog")
    public void saveUserEventLog(@RequestBody UserEventLog userEventLog);
}
