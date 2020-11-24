package com.wyh.handler;

import com.wyh.response.Result;
import com.wyh.response.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


    /*
    * 全局异常处理，没有指定异常的类型，不管什么异常都是可以捕获的
    * */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        return Result.error();
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        return Result.error().code(ResultCode.ARITHMETIC_EXCEPTION.getCode()).message(ResultCode.ARITHMETIC_EXCEPTION.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result error(BusinessException e){
        return Result.error().code(e.getCode()).message(e.getErrMsg());
    }
}
