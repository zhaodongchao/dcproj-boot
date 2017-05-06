package org.dongchao.core.utils;

import org.dongchao.core.model.Result;

/**
 * 使用单列模式获取Result对象
 * Created by zhaodongchao on 2017/5/5.
 */
public class ResultUtil {
    private static Result result;

    public static  Result getResult(Integer status, String message,Object... data) {
        if (null == result) {
            result = new Result(status,message,data);
        }else {
            result.setStatus(status);
            result.setMessage(message);
            result.setData(data);
        }
        return result;
    }

}
