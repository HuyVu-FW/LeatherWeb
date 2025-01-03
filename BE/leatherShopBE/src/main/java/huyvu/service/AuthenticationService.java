package huyvu.service;

import huyvu.dto.request.User.UserLoginRequest;
import huyvu.dto.request.User.UserRegisterRequest;
import huyvu.dto.respon.User.UserLoginResponse;

public interface AuthenticationService {
    String register(UserRegisterRequest userRegisterRequest);

    UserLoginResponse login(UserLoginRequest userLoginRequest);
}
