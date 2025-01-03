package huyvu.security;


import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import huyvu.model.User;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.StringJoiner;

@Slf4j  //dùng log bên dưới

@Service
public class JwtUtil {

    @NonFinal
    @Value("${jwt.secretkey}")
    private String SECRET_KEY;

    public  String genarateToken(User user) {
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getId())
                .issuer("Huy Vũ")
                .issueTime(new Date())
                .expirationTime(new Date(new Date().getTime() + 1000 * 60 * 60 * 24))
                .claim("customClaim", "customname")
                .claim("scope", mapRolesToScope(user))
                .build();
//        Conver cái trên sang JSON object
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        try {
            jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Can not crate token");
            throw new RuntimeException(e);
        }


    }


    public static String mapRolesToScope(User user) {
        // Kiểm tra nếu roles của user null hoặc rỗng, trả về chuỗi rỗng
        if (CollectionUtils.isEmpty(user.getRoles())) {
            return "";
        }

        // Sử dụng StringJoiner để nối các roles thành chuỗi
        StringJoiner joiner = new StringJoiner(" ");
        user.getRoles().forEach(joiner::add); // Lấy từng role và thêm vào joiner

        return joiner.toString(); // Trả về chuỗi scope
    }

}
