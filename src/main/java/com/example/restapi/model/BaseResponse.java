package com.example.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> implements Serializable {

    private int status;
    private boolean success;
    private String message;

    private T data;


    public static <T> BaseResponse<T> ok(T data) {
        return BaseResponse.<T>builder()
                .success(true)
                .status(200)
                .message("OK")
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> internalError() {
        return BaseResponse.<T>builder()
                .status(500)
                .success(false)
                .message("Internal Server Error")
                .data(null)
                .build();
    }
}
