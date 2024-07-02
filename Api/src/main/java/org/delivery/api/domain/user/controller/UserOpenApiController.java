package org.delivery.api.domain.user.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.delivery.api.common.api.Api;
import org.delivery.api.domain.token.controller.model.TokenResponse;
import org.delivery.api.domain.user.business.UserBusiness;
import org.delivery.api.domain.user.controller.model.UserLoginRequest;
import org.delivery.api.domain.user.controller.model.UserRegisterRequest;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/user")//회원가입이나 약관과 같은거는 로근인이
//없다 그렇기 때문에 open-api를 통해 인터셉터를 통과시켜줘야 된다.
public class UserOpenApiController {

    private final UserBusiness userBusiness;

    //사용자 가입 요청
    @PostMapping("/register")
    public Api<UserResponse> register(
        @Valid
        @RequestBody Api<UserRegisterRequest> request
    ){
        var response = userBusiness.register(request.getBody());

        return Api.OK(response);
    }

    @PostMapping("/login")
    public Api<TokenResponse> login(
        @Valid
        @RequestBody Api<UserLoginRequest> request
    ) {
        var response = userBusiness.login(request.getBody());
        return Api.OK(response);
    }
}
