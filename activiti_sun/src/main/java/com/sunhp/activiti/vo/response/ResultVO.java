package com.sunhp.activiti.vo.response;

import com.sujian.blindbox.enums.ResponseCodeEnum;
import lombok.Data;

/**
 * @author sujian
 * @Description 统一响应体
 **/
@Data
public class ResultVO<T> {
    private Boolean state;
    private String code;
    private String message;
    private T body;

    public ResultVO(){
    }

    public ResultVO(Boolean state, String code, String msg){
        this.state = state;
        this.code = code;
        this.message = msg;
    }

    public ResultVO(Boolean state, ResponseCodeEnum responseCodeEnum){
        this.state = state;
        this.code = responseCodeEnum.getCode();
        this.message = responseCodeEnum.getMsg();
    }

    public ResultVO(Boolean state, ResponseCodeEnum responseCodeEnum,T data) {
        this.state = state;
        this.code = responseCodeEnum.getCode();
        this.message= responseCodeEnum.getMsg();
        this.body = data;
    }

    //建议使用以下带state状态的方法

    /**
     * 调用成功，自定义码值
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO getSuccess(String code,String msg){
        return new ResultVO(true, code, msg);
    }

    /**
     * 调用成功 + 返回数据
     * @param responseCodeEnum
     * @param data
     * @return
     */
    public static <T> ResultVO getSuccessBody(ResponseCodeEnum responseCodeEnum, T data){
        return new ResultVO(true, responseCodeEnum, data);
    }

    /**
     * 调用成功，枚举码值
     * @param responseCodeEnum
     * @return
     */
    public static ResultVO getSuccess(ResponseCodeEnum responseCodeEnum){
        return new ResultVO(true, responseCodeEnum);
    }

    /**
     * 调用失败，枚举码值
     * @param responseCodeEnum
     * @return
     */
    public static ResultVO getFail(ResponseCodeEnum responseCodeEnum){
        return new ResultVO(false, responseCodeEnum);
    }

    /**
     * 调用失败，自定义码值
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO getFail(String code,String msg){
        return new ResultVO(false, code, msg);
    }
}
