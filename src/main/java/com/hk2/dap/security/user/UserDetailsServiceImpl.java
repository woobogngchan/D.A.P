package com.hk2.dap.security.user;

import com.hk2.dap.domain.user.entity.User;
import com.hk2.dap.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String studentId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(studentId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        return new UserDetailsImpl(user, user.getUserId());
    }

}
