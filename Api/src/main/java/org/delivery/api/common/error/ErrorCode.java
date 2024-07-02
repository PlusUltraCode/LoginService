package org.delivery.api.common.error;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode implements ErrorCodeIfs {

    OK(200,200,"성공"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400,"잘못된 요청"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500,"서버에러"),

    NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512, "Null pointer"),
    ;

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;

}
