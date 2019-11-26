package com.ntyx.file.common.vo;

import com.ntyx.file.common.exception.NtyxException;
import lombok.Data;
import org.joda.time.DateTime;

/**
 * @program:
 * @description: 给前端返回异常对象
 **/
@Data
public class ExceptionResult {

    private Integer status;
    private String message;
    private String timeStampt;


    public ExceptionResult(NtyxException e) {
        this.status = e.getStatus();
        this.message = e.getMessage();
        this.timeStampt = DateTime.now().toString("yyyy-MM-dd hh:mm:ss");
    }
}
