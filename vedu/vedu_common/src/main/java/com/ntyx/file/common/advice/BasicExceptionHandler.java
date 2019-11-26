package com.ntyx.file.common.advice;

import com.ntyx.file.common.exception.NtyxException;
import com.ntyx.file.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @program:
 * @description: 当controller层抛出异常 统一在这处理
 **/
@ControllerAdvice  // 当controller抛出异常后，异常处理
public class BasicExceptionHandler {

    //处理不同异常
    @ExceptionHandler(RuntimeException.class)  //按照异常类型处理异常
    public ResponseEntity<String> runtimeError(RuntimeException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(NtyxException.class)
    public ResponseEntity<ExceptionResult> lyError(NtyxException e){
        return ResponseEntity.status(e.getStatus()).body(new ExceptionResult(e));
    }

}
