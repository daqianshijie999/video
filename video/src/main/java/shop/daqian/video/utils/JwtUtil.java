package shop.daqian.video.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author daqian
 * @create 2021/12/31 12:26
 */
public class JwtUtil {
   private String key = "iiuh#&……￥*huhuh";
    public  String  getToken(){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE,5);//设置过期时间
        String token = JWT.create()
                .withClaim("username","admin")
//                .withJWTId("2")
//                .withArrayClaim("type",new String[]{"user","Video"})
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(key));
        return token;
    }
    public void verify(String token){
        JWTVerifier jwtVerifier =  JWT.require(Algorithm.HMAC256(key)).build();
        DecodedJWT verify = jwtVerifier.verify(token);
        System.out.println(verify.getClaim("username").asString());
    }
    public static void main(String[] args) {
        JwtUtil jwtUtil = new JwtUtil();
        jwtUtil.verify( jwtUtil.getToken());

    }
}
