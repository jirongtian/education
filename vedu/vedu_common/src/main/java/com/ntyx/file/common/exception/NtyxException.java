package com.ntyx.file.common.exception;

import com.ntyx.file.common.enums.ExceptionEnum;
import lombok.Data;

@Data
public class NtyxException extends RuntimeException{

    //存放异常状态码
    private Integer status;

    public NtyxException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.status = exceptionEnum.getStatus();
    }

    public NtyxException(ExceptionEnum exceptionEnum, Throwable cause) {
        super(exceptionEnum.getMessage(), cause);
        this.status = exceptionEnum.getStatus();
    }
}
