package com.hk2.dap.domain.user.controller;

import com.hk2.dap.domain.user.dto.UserRequestDto;
import com.hk2.dap.domain.user.service.UserService;
import com.hk2.dap.security.user.UserDetailsImpl;
import com.hk2.dap.util.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity<MessageDto> userJoin(UserRequestDto.UserJoin userJoin){
        return userService.userJoin(userJoin);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<MessageDto> userLogin(UserRequestDto.UserLogin userLogin){

        return userService.userLogin(userLogin);
    }

    @DeleteMapping("/api/user")
    public ResponseEntity<MessageDto> userDelete(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam UserRequestDto.UserDelete userDelete){

        return userService.userDelete(userDetails.getUser(), userDelete);
    }

}
