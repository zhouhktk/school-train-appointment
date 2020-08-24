package com.st.exception;

import com.st.data.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常处理
 * @author : zhoufeng
 * @date : 2020/8/17
 */
@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(StaffException.class)
    @ResponseBody
    public ResponseVo exceptionHandler(StaffException ae){
        return new ResponseVo(ae.getCode(), ae.getMsg(), null);
    }
}
