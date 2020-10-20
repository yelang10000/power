package com.sun.power.core.common.controller;


import com.sun.power.core.exception.PowerException;
import com.sun.power.core.support.HttpKit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  
* 类说明   
*  
* @author 贾涛
* @date 2018年8月30日  新建  
*/
public class BaseController{


    protected static String SUCCESS = "SUCCESS";
    protected static String ERROR = "ERROR";

    protected static String REDIRECT = "redirect:";
    protected static String FORWARD = "forward:";
    protected HttpServletRequest getHttpServletRequest() {
        return HttpKit.getRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return HttpKit.getResponse();
    }
    protected String getPara(String name) {
        return HttpKit.getRequest().getParameter(name);
    }

    /**
     * 正常数据返回
     * @param data
     * @return
     */
    public <T> ResponseEntity<T> success(T data){
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    /**
     * 业务错误返回
     * @param message 错误信息标识
     * @param <T>
     * @return
     */
    public <T> ResponseEntity<T> serviceError(String message){
        throw new PowerException(message);
    }

//    /**
//     * 业务错误返回
//     * @param message 错误信息标识
//     * @param data 错误数据
//     * @param <T>
//     * @param <V>
//     * @return
//     */
//    public <T,V> ResponseEntity<T> serviceError(String message, V data){
//        throw new ServiceErrorException(message, data);
//    }
}
