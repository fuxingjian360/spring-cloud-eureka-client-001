package com.gupao.xing.jian.common.advice;

import com.gupao.xing.jian.common.util.ResultVO;
import com.gupao.xing.jian.common.exception.MyRuntimeException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return new ResultVO<String>(1001,"参数验证失败",error.getDefaultMessage());
    }

    @ExceptionHandler(MyRuntimeException.class)
    public ResultVO<String> myRuntimeExceptionHandle(MyRuntimeException e) {
        return  new ResultVO<String>(e.getCode(),"业务执行异常",e.getMessage());
    }

}
