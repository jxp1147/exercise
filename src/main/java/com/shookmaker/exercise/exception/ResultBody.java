package com.shookmaker.exercise.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBody {
    private Integer code;
    private String message;
    private Object data;
    
    public ResultBody(BaseInfo baseInfo) {
        this.code = baseInfo.getResultCode();
        this.message = baseInfo.getResultMsg();
    }

    // 成功
    public static ResultBody success(Object data) {
        return new ResultBody(200, "success", data);
    }
    // 成功
    public static ResultBody success() {
        return new ResultBody(200, "success", null);
    }

    // 失败
    public static ResultBody error(BaseInfo baseInfo) {
        return new ResultBody(baseInfo.getResultCode(), baseInfo.getResultMsg(), null);
    }

    // 失败
    public static ResultBody error(Integer code, String message) {
        return new ResultBody(code, message, null);
    }

    // 失败
    public static ResultBody error(String message) {
        return new ResultBody(-1, message, null);
    }
}
