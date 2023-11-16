package com.hk2.dap.domain.user.serviceimpl;

import com.hk2.dap.domain.user.dto.UserRequestDto;
import com.hk2.dap.domain.user.entity.User;
import com.hk2.dap.domain.user.repository.UserRepository;
import com.hk2.dap.domain.user.service.UserService;
import com.hk2.dap.security.jwt.JwtUtil;
import com.hk2.dap.util.dto.ErrorCode;
import com.hk2.dap.util.dto.MessageDto;
import com.hk2.dap.util.dto.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<MessageDto> userJoin(UserRequestDto.UserJoin userJoin) {
        String password = passwordEncoder.encode(userJoin.getUserPassword());

        Optional<User> userId = userRepository.findByUserId((userJoin.getUserId()));

        if (userId.isPresent()) {
            throw new MessageDto(ErrorCode.DUPLICATE_EMAIL);
        }

        User user = User.builder()
                .userId(userJoin.getUserId())
                .userName(userJoin.getUserName())
                .userPassword(password)
//                .userPassword(userJoin.getuserPassword())
                .userType(userJoin.getUserType())
                .nickName(userJoin.getNickName())
                .phoneNum(userJoin.getPhoneNum())
                .build();
        userRepository.save(user);

        return MessageDto.toResponseEntity(SuccessCode.JOIN_SUCCESS);
    }

    @Override
    public ResponseEntity<MessageDto> userLogin(UserRequestDto.UserLogin userLogin) {
        User user = userRepository.findByUserId(userLogin.getUserId()).orElseThrow(() -> new MessageDto(ErrorCode.DUPLICATE_EMAIL));

        if (!passwordEncoder.matches(userLogin.getUserPassword(), user.getUserPassword()))
            throw new MessageDto(ErrorCode.DUPLICATE_EMAIL);

        HttpHeaders headers = new HttpHeaders();
        headers.set(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getUserId()));

        return ResponseEntity.ok()
                .headers(headers)
                .body(MessageDto.of(SuccessCode.LOGIN_SUCCESS));
    }
}