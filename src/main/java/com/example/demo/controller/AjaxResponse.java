package com.example.demo.controller;

import com.example.demo.config.exception.CustomException;
import com.example.demo.config.exception.CustomExceptionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "网络请求返回类")
public class AjaxResponse {
    @ApiModelProperty(value = "请求是否成功")
    private boolean isSuccess;
    @ApiModelProperty(value = "请求响应状态码",example = "200、400、500")
    private int code;
    @ApiModelProperty(value = "请求结果描述信息")
    private String message;
    @ApiModelProperty(value = "请求结果数据")
    private Object data;

    public static AjaxResponse error(CustomException e){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.isSuccess = false;
        ajaxResponse.code = e.getCode();
        if(e.getCode() == CustomExceptionType.USER_INPUT_ERROR.getCode()){
            ajaxResponse.message = e.getMessage();
        }else if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            ajaxResponse.message = e.getMessage()+",系统异常,请联系管理员电话:13462439645";
        }else {
            ajaxResponse.message = e.getMessage()+",系统出现未知异常,请联系管理员电话:13462439645";
        }
        return ajaxResponse;
    }

    public static AjaxResponse success(Object object){
        AjaxResponse ajaxResponse =  new AjaxResponse();
        ajaxResponse.isSuccess = true;
        ajaxResponse.code=200;
        ajaxResponse.message = "请求成功";
        ajaxResponse.data = object;
        return ajaxResponse;
    }
    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.isSuccess = true;
        ajaxResponse.code=200;
        ajaxResponse.message = "请求成功";
        return ajaxResponse;
    }
    public static AjaxResponse error(String msg){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.isSuccess = false;
        ajaxResponse.code=400;
        ajaxResponse.message =msg;
        return ajaxResponse;
    }
}
