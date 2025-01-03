package huyvu.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public enum ResponseCode {
    //user


//    User

    REGISTER_SUCCESSFULL(HttpStatus.CREATED, 101, "Register Successfull"),
    USER_EXISTED(HttpStatus.CONFLICT, 102, "User Existed"),
    USER_LOGIN_FAILED(HttpStatus.BAD_REQUEST, 205, "Username or Password Incorrect"),
    USER_LOGIN_SUCCESSFUL(HttpStatus.OK, 205, "User login succesfull"),


    //    Category
    CATEGORY_CREATE_SUCCESSFUL(HttpStatus.CREATED, 101, "Category Create Successfull"),
    CATEGORY_IS_EXISTED(HttpStatus.CONFLICT, 404, "Category Existed"),
    CATEGORY_NOT_EXISTED(HttpStatus.CONFLICT, 404, "Category Not Existed"),

    //    Product
    PRODUCT_NOT_EXISTED(HttpStatus.CONFLICT, 404, "Product Not Existed"),
    ;


    HttpStatus status;
    int code;
    String message;


}
