package com.hk2.dap.domain.user.service;

import com.hk2.dap.domain.user.dto.UserRequestDto;
import com.hk2.dap.util.dto.MessageDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<MessageDto> userJoin(UserRequestDto.UserJoin userJoin);

    ResponseEntity<MessageDto> userLogin(UserRequestDto.UserLogin userLogin);
}
