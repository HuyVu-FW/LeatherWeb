package huyvu.service.Imp;

import huyvu.dto.request.User.UserLoginRequest;
import huyvu.dto.request.User.UserRegisterRequest;
import huyvu.dto.respon.User.UserLoginResponse;
import huyvu.enums.Role;
import huyvu.exception.AppException;
import huyvu.exception.ResponseCode;
import huyvu.model.User;
import huyvu.repository.UserRepository;
import huyvu.security.JwtUtil;
import huyvu.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class AuthenticationImp implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    @Override
    public String register(UserRegisterRequest userRegisterRequest){
        if(userRepository.existsByUsername(userRegisterRequest.getUsername()))
            throw  new AppException(ResponseCode.USER_EXISTED);

         User user = User.builder()
                 .username(userRegisterRequest.getUsername())
                 .name(userRegisterRequest.getFullname())
                 .password(passwordEncoder.encode(userRegisterRequest.getPassword()))
                 .roles(Set.of(Role.USER.name()))
                 .build();
         userRepository.save( user );


       return "Register Success";
    }

    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        var user = userRepository.findByUsername(userLoginRequest.getUsername()).orElseThrow(
                ()->new AppException(ResponseCode.USER_EXISTED));
        if(!passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword()))
            throw  new AppException(ResponseCode.USER_LOGIN_FAILED);
        return UserLoginResponse.builder()
                .authenticated(true)
                .token(jwtUtil.genarateToken(user))
                .build();
    }
}
