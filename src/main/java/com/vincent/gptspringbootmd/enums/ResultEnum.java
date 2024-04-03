package com.vincent.gptspringbootmd.enums;

/**
 * @version v1.0
 * @ProjectName: lmp -2
 * @ClassName: ResultEnum
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Topcheer
 * @Date: 2024/2/6 15:07
 */
public enum ResultEnum implements IResponseEnum {
    SUCCESS(200,"接口调用成功!"),
    COMMON_FAILED(201, "接口调用失败");


    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
