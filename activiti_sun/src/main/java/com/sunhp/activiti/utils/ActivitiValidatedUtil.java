package com.sunhp.activiti.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * @author sujian
 * @Description 参数校验结果整合工具类
 **/
public class ActivitiValidatedUtil {
    /**
     * 拼接参数校验信息
     * @param ex
     * @return
     */
    public static String getColumnAndMessage(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder();
        for (FieldError error : bindingResult.getFieldErrors()) {
            String field = error.getField();
            Object value = error.getRejectedValue();
            String msg = error.getDefaultMessage();
            String message = String.format("错误字段：%s，错误值：%s，原因：%s；", field, value, msg);
            sb.append(message);
        }
        return sb.toString();
    }

    /**
     * 拼接校验信息，只组装失败原因
     * @param ex
     * @return
     */
    public static String getMessage(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder();
        for (FieldError error : bindingResult.getFieldErrors()) {
            String msg = error.getDefaultMessage();
            String message = String.format("%s；", msg);
            sb.append(message);
        }
        return sb.toString();
    }
}
