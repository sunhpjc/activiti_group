package com.sunhp.activiti.vo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author sujian
 * @Description 用户请求VO
 **/
@Data
public class UserReqVO {
    @Length(max = 20, message = "用户名最长不能超过20个字符")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;
}
