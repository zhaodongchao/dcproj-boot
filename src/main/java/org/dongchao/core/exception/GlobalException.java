package org.dongchao.core.exception;

/**
 * 自定义全局异常
 * Created by zhaodongchao on 2017/5/5.
 */
public class GlobalException extends RuntimeException {
    private Integer exceptionCode ;
    private String exceptionMessage ;

    public GlobalException(String message, Integer exceptionCode, String exceptionMessage) {
        super(message);
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }

    public Integer getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(Integer exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
