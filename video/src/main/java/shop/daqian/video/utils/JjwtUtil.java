package shop.daqian.video.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author daqian
 * @create 2022/1/13 21:16
 */
public class JjwtUtil {
    private  static final String jwtToken="%$Fy87%^$*7";

    public static String createToken(Long userId){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.SECOND,24);

        Map<String,Object> claims = new HashMap<>();
        claims.put("userId",userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512,jwtToken)
                .setClaims(claims)
                .setExpiration(calendar.getTime());
        String token = jwtBuilder.compact();
        return token;
    }
    public static Map<String,Object> checkToken(String token){
        try {
//            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            Jwt parse = Jwts.parser()
                    .setSigningKey(jwtToken)
                    .parseClaimsJws(token);
            return (Map<String,Object>) parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String token =JjwtUtil.createToken(123L);
        System.out.println(token);
        Map<String,Object> map = JjwtUtil.checkToken(token);
        System.out.println(map.get("userId"));
    }
}
