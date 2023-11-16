package com.hk2.dap.domain.user.controller;

import com.hk2.dap.domain.user.dto.UserRequestDto;
import com.hk2.dap.domain.user.service.UserService;
import com.hk2.dap.util.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/user")
    public ResponseEntity<MessageDto> userJoin(UserRequestDto.UserJoin userJoin){
        return userService.userJoin(userJoin);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<MessageDto> userLogin(UserRequestDto.UserLogin userLogin){

        return userService.userLogin(userLogin);
    }

}
