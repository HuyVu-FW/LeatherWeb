package huyvu.controller;


import huyvu.dto.ApiResponse;
import huyvu.dto.request.User.UserLoginRequest;
import huyvu.dto.request.User.UserRegisterRequest;
import huyvu.dto.respon.User.UserLoginResponse;
import huyvu.exception.ResponseCode;
import huyvu.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    @PostMapping("register/")
    public ApiResponse<String> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        return new ApiResponse<>(200, HttpStatus.ACCEPTED, "hello", authenticationService.register(userRegisterRequest));
    }

    @PostMapping("login/")
    public ApiResponse<UserLoginResponse> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        return new ApiResponse<>(ResponseCode.USER_LOGIN_SUCCESSFUL,authenticationService.login(userLoginRequest));
    }


    @PostMapping("/logout")
    public String logout() {
        return "Logout endpoint";
    }

    @PostMapping("/refresh-token")
    public String refreshToken() {
        return "Refresh Token endpoint";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword() {
        return "Forgot Password endpoint";
    }

    @PostMapping("/reset-password")
    public String resetPassword() {
        return "Reset Password endpoint";
    }

    @PostMapping("/verify")
    public String verify() {
        return "Verify endpoint";
    }

    @GetMapping("/status")
    public String status() {
        return "Status endpoint";
    }


}
