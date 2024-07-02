package org.delivery.db.user.enums;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public enum UserStatus {

    REGISTERED("등록"),
    UNREGISTERED("해지"),
    ;


    private final String description;
}
