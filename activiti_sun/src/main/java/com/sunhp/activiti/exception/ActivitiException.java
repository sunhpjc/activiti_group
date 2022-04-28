package com.sunhp.activiti.exception;


import com.sunhp.activiti.enums.ResponseCodeEnum;

/**
 * @author sujian
 * @Description 自定义异常
 **/
public class ActivitiException extends RuntimeException{
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public ActivitiException() {
        this("1001", "接口错误");
    }

    public ActivitiException(String msg) {
        this("1001", msg);
    }

    public ActivitiException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 建议使用枚举类，便于码值维护
     * @param resp
     */
    public ActivitiException(ResponseCodeEnum resp) {
        super(resp.getMsg());
        this.code = resp.getCode();
        this.msg = resp.getMsg();
    }
}
