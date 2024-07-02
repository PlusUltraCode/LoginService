package org.delivery.api.domain.user.business;


import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.domain.token.business.TokenBusiness;
import org.delivery.api.domain.token.controller.model.TokenResponse;
import org.delivery.api.domain.user.controller.model.UserLoginRequest;
import org.delivery.api.domain.user.controller.model.UserRegisterRequest;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.delivery.api.domain.user.converter.UserConverter;
import org.delivery.api.domain.user.service.UserService;

@Business
@RequiredArgsConstructor //복잡한 로직을 처리하는 곳
public class UserBusiness {

    private final UserService userService;
    private final UserConverter userConverter;

    private final TokenBusiness tokenBusiness;

    /*
    * 사용자에 대한 가입처리 로직
    * 1. request -> entity
    *  2. entity - > save
    * 3. save entity -> response
    * 4. response return
    * */
    public UserResponse register(UserRegisterRequest request) {

        var entity = userConverter.toEntity(request);
        var newEntity = userService.register(entity);
        var response = userConverter.toResponse(newEntity);
        return response;
    }

    /*
    * 1. email, password 를 가지고 사용자 체크
    * 2. user entity  로그인 확인
    * 3. token 생성
    * 4. token response 로 반환
    *
    * */

    public TokenResponse login(UserLoginRequest request) {
        var userEntity = userService.login(request.getEmail(),request.getPassword());
        // 사용자 없으면 throw

        // ToDo 토큰 생성 로직으로 변경하기

        var tokenResponse = tokenBusiness.issueToken(userEntity);
        return tokenResponse;
    }

    public  UserResponse me(Long userId) {
        var userEntity = userService.getUserWithThrow(userId);
        var response = userConverter.toResponse(userEntity);
        return response;
    }
}
