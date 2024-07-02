package org.delivery.api.domain.token.business;


import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.token.controller.model.TokenResponse;
import org.delivery.api.domain.token.converter.TokenConverter;
import org.delivery.api.domain.token.service.TokenService;
import org.delivery.db.user.UserEntity;

import java.util.Optional;

@RequiredArgsConstructor
@Business
public class TokenBusiness {

    private final TokenConverter tokenConverter;
    private final TokenService tokenService;


    /*
    * 1. user entity user id 추출
    * 2. user id 를 통해 access, refresh token 발행
    * 3. converter -> token response 변환
    * */

    public TokenResponse issueToken(UserEntity userEntity){

        return Optional.ofNullable(userEntity)
                .map(ue->{
                    return ue.getId();
                })
                .map(userId ->{
                    var accessToken = tokenService.issueAccessToken(userId);
                    var refreshToken = tokenService.issueRefreshToken(userId);

                    return tokenConverter.toResponse(accessToken,refreshToken);

                })
                .orElseThrow(()->new ApiException(ErrorCode.NULL_POINT));
    }

    public Long validationToken(String accessToken){
        var userId = tokenService.validationToken(accessToken);
        return userId;
    }

}
