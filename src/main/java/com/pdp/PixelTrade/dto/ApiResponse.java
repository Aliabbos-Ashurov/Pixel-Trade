package com.pdp.PixelTrade.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  10:34
 **/
@Getter
@Setter
public class ApiResponse<E> implements DTO {

    private boolean success;
    private int status;
    private E data;
    private String message;
    private ErrorMessageDTO error;

    public static <E> ApiResponse<E> ok(E data) {
        return new ApiResponse<>(true, 200, data, "Operation successful", null);
    }

    public static <E> ApiResponse<E> ok(int status, E data) {
        return new ApiResponse<>(true, status, data, "Operation successful", null);
    }

    public static <E> ApiResponse<E> ok(HttpStatus httpStatus, E data) {
        return new ApiResponse<>(true, httpStatus.value(), data, "Operation successful", null);
    }

    public static <E> ApiResponse<E> error(int status, ErrorMessageDTO error) {
        return new ApiResponse<>(false, status, null, "Operation failed", error);
    }

    public static <E> ApiResponse<E> error(HttpStatus status, ErrorMessageDTO error) {
        return new ApiResponse<>(false, status.value(), null, "Operation failed", error);
    }

    private ApiResponse(boolean success, int status, E data, String message, ErrorMessageDTO error) {
        this.success = success;
        this.status = status;
        this.data = data;
        this.message = message;
        this.error = error;
    }
}
