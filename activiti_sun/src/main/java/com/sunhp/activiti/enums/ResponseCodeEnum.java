package com.sunhp.activiti.enums;

import com.sunhp.activiti.exception.ActivitiException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author sujian
 * @Description 响应枚举类
 **/
public enum ResponseCodeEnum {
    SUCCESS("1000","请求成功"),
    FAILED("1001","请求失败"),
    REQUEST_PARAM_FAILED("2000","请求参数缺失"),
    ENUMS_ERROR("2001","枚举类型错误"),
    VALIDATED_PARAM_FAILED("2002","校验参数异常"),
    NULL_POINT("5001","空指针异常"),
    UNEXPECTED_EXCEPTION("5000", "系统发生异常，请联系管理员！")
    ;
    private String code;
    private String msg;

    ResponseCodeEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ResponseCodeEnum getByCode(String code){
        if(StringUtils.isNotEmpty(code)){
            for (ResponseCodeEnum ResVO: values()
            ) {
                if(ResVO.code.equals(code)){
                    return ResVO;
                }
            }
        }
        throw new ActivitiException(ENUMS_ERROR);
    }
}
