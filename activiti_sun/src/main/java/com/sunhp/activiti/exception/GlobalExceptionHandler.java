package com.sunhp.activiti.exception;

import com.sujian.blindbox.enums.ResponseCodeEnum;
import com.sujian.blindbox.utils.BlindBoxValidatedUtil;
import com.sujian.blindbox.vo.response.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author sujian
 * @Description 异常捕获类
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     *  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)可以改变响应的http code
     */

    /**
     * 参数缺失异常,前后端分离的情况下，做参数缺失异常处理，返回给前端一个友好提示
     * @param ex
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultVO handleHttpMessageNotReadableException(MissingServletRequestParameterException ex){
        log.error("请求参数缺失，{}",ex);
        return ResultVO.getFail(ResponseCodeEnum.REQUEST_PARAM_FAILED);
    }

    /**
     * 参数校验异常
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        String message = BlindBoxValidatedUtil.getColumnAndMessage(ex);
        log.error("校验参数异常 ===> {}",message);
        String result = BlindBoxValidatedUtil.getMessage(ex);
        return ResultVO.getFail(ResponseCodeEnum.VALIDATED_PARAM_FAILED.getCode(), result);
    }

    /**
     * 空指针异常
     * @param ex
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public ResultVO handleNullPointerException(NullPointerException ex){
        log.error("空指针异常，请管理员及时处理{}",ex);
        return ResultVO.getFail(ResponseCodeEnum.NULL_POINT);
    }

    /**
     * 拦截自定义异常
     * @param ex
     * @return
     */
    @ExceptionHandler(ActivitiException.class)
    public ResultVO handleBlindBoxException(ActivitiException ex) {
        String code = ex.getCode();
        String message = ex.getMsg();
        return ResultVO.getFail(code, message);
    }

    /**
     * 所有异常都继承自exception，通常可以把这个放到最后，如果上面的异常都没有，那么异常归为预期外异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultVO handleUnexpectedServer(Exception ex) {
        log.error("系统异常, 请管理员及时处理：{}", ex);
        return ResultVO.getFail(ResponseCodeEnum.UNEXPECTED_EXCEPTION);
    }
}
