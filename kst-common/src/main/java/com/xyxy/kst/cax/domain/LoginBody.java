package com.xyxy.kst.cax.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lh
 * @version 1.0v
 * @date 2022/5/30 19:17
 * @description
 */
@Data
@NoArgsConstructor
@ToString
public class LoginBody {

    private String userName;
    private String password;
}
