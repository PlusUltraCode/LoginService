package org.delivery.api.common.error;

import lombok.Getter;


public interface ErrorCodeIfs {

    Integer getHttpStatusCode();
    Integer getErrorCode();
    String getDescription();
}
