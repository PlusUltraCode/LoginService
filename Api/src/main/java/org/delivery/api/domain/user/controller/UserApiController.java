package org.delivery.api.domain.user.controller;


import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.UserSession;
import org.delivery.api.common.api.Api;
import org.delivery.api.domain.user.business.UserBusiness;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.delivery.api.domain.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
//로그인 된 사용자가 들어오는 곳
//controller -> business(user,token)을 다시 controller 넘김 -> service -> repository
public class UserApiController {

    private final UserBusiness userBusiness;

    @GetMapping("/me")
    public Api<UserResponse> me(
            @UserSession User user
    ){


        //scopreRequest 이거는 한번만 저장한다 는 뜻이다.

        var response = userBusiness.me(user.getId());
        return Api.OK(response);
    }
}
