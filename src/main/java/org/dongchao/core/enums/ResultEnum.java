package org.dongchao.core.enums;

/**
 * 创建枚举类，定义好能预料的系统状态
 * Created by zhaodongchao on 2017/5/5.
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知系统错误"),
    SUCCESS(0,"成功")
    ;
    private Integer resultCode ;
    private String message ;

    ResultEnum(Integer resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
