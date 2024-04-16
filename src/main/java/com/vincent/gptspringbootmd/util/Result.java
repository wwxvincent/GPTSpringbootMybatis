package com.vincent.gptspringbootmd.util;



import com.vincent.gptspringbootmd.enums.ResultEnum;
import com.vincent.gptspringbootmd.exception.BaseException;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("统一返回结果类")
public class Result<T> {

    private int code;
    private String message;
    private T data;
    private boolean success;

    public static <T> Result<T> success() {
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null,true);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data, true);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), message, data, true);
    }

    public static Result<?> failed() {
        return new Result<>(ResultEnum.COMMON_FAILED.getCode(), ResultEnum.COMMON_FAILED.getMessage(), null, false);
    }

    public static Result<?> failed(String message) {
        return new Result<>(ResultEnum.COMMON_FAILED.getCode(), message, null, true);
    }

    public static Result<?> failed(ResultEnum enumEx){
        return new Result<>(enumEx.getCode(),enumEx.getMessage(),null, true);
    }

    public static Result<?> failed(ResultEnum enumEx,String message){
        return new Result<>(enumEx.getCode(),message,null, true);
    }
    public static Result<?> failed(BaseException ex){
        return new Result<>(ex.getCode(),ex.getMsg(),null, false);
    }

    public static <T> Result<T> instance(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
