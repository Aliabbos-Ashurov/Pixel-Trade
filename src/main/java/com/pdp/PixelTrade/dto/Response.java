package com.pdp.PixelTrade.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pdp.PixelTrade.dto.marker.DTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  10:34
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Response<E> implements DTO {

    private boolean success;
    private int status;
    private E data;
    private String message;
    private ErrorResponse error;

    public static <E> Response<E> ok(E data) {
        return new Response<>(true, 200, data, null, null);
    }

    public static <E> Response<E> ok(int status, E data) {
        return new Response<>(true, status, data, null, null);
    }

    public static <E> Response<E> ok(HttpStatus httpStatus, E data) {
        return new Response<>(true, httpStatus.value(), data, null, null);
    }

    public static <E> Response<E> error(int status, ErrorResponse error) {
        return new Response<>(false, status, null, null, error);
    }

    public static <E> Response<E> error(HttpStatus status, ErrorResponse error) {
        return new Response<>(false, status.value(), null, null, error);
    }

    private Response(boolean success, int status, E data, String message, ErrorResponse error) {
        this.success = success;
        this.status = status;
        this.data = data;
        this.message = message;
        this.error = error;
    }
}
