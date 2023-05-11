package com.xyxy.kst.cax.remote.savelog;

import com.xyxy.kst.cax.entity.UserEventLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(contextId = "remoteSaveLog", value = "kst-service-admin")
public interface RemoteSaveLog {
    /**
     * 保存日志
     * @param userEventLog
     */
    @PostMapping("/api/admin/saveUserEventLog")
    public void saveUserEventLog(@RequestBody UserEventLog userEventLog);
}
