package org.dongchao.core.exception;

import org.dongchao.core.model.Result;
import org.dongchao.core.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统统一异常的处理类
 * Created by zhaodongchao on 2017/5/5.
 */
@ControllerAdvice
public class ExceptionCapture {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handlerException(Exception e){
        if (e instanceof GlobalException){
            GlobalException globalException = (GlobalException) e ;
            return ResultUtil.getResult(globalException.getExceptionCode(),globalException.getMessage());
        }else {
            return ResultUtil.getResult(-1,e.getMessage());
        }
    }
}
