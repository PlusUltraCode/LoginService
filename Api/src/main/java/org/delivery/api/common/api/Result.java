package org.delivery.api.common.api;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.api.common.error.ErrorCodeIfs;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {

    private Integer resultCode;

    private String resultMessage;

    private String resultDescription;

    public static Result Ok(){
        return Result.builder()
                .resultCode(200)
                .resultMessage("성공")
                .resultDescription("안녕하세요")
                .build();
    }

    public static Result ERROR(ErrorCodeIfs errorCodeIfs){
        return Result.builder()
                .resultCode(errorCodeIfs.getErrorCode())
                .resultMessage(errorCodeIfs.getDescription())
                .resultDescription("에러")
                .build();
    }

    public static Result ERROR(ErrorCodeIfs errorCodeIfs, Throwable tx){
        return Result.builder()
                .resultCode(errorCodeIfs.getErrorCode())
                .resultMessage(errorCodeIfs.getDescription())
                .resultDescription(tx.getLocalizedMessage())
                .build();
    }

    public static Result ERROR(ErrorCodeIfs errorCodeIfs,  String description){
        return Result.builder()
                .resultCode(errorCodeIfs.getErrorCode())
                .resultMessage(errorCodeIfs.getDescription())
                .resultDescription(description)
                .build();
    }
}
