package cn.jijl.mist.common.utils;

import cn.jijl.mist.common.exception.AuthException;
import cn.jijl.mist.common.result.ResultEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.Optional;

/**
 * @Author jijl
 * @Description: JWT工具类
 * @Date 17:29 2019/10/28
 * @Param
 * @return
 **/
public class JwtUtil {


    private static String audience = "53391fjs2dfh238hsjfhsjk8534eu1hsgdfgj89h";

    private static String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";

    private static String issuer = "restapiauthtication";

    /**
     * 解析jwt
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            //解析token
            Claims claims = Jwts.parser()
                    .setSigningKey(base64Security.getBytes())
                    .parseClaimsJws(jsonWebToken).getBody();
            Optional<Claims> claimsOptional = Optional.of(claims);
            if (claimsOptional.isPresent()) {
                Date expiration = claimsOptional.get().getExpiration();
                if (expiration.before(expiration)) {
                    throw new AuthException(ResultEnum.CODE_4);
                }
            }
            return claims;
        } catch (Exception ex) {
            return null;
        }
    }

//    public static void main(String[] args) {
//        System.out.println(createJWT(  "managerId",   "123456",   66666));
//        System.out.println(parseJWT(  createJWT(  "managerId",   "123456",   66666),base64Secret));
//    }

    /**
     * 构建jwt
     */

    public static String createJWT(String unique, String uniqueId, long TTLMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = base64Secret.getBytes();
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("ljb", "JwtUtil")
                .claim(unique, uniqueId)
                .setIssuer(issuer)
                .setAudience(audience)
                .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (TTLMillis >= 0) {
            long expMillis = nowMillis + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }

    public static Integer getUniqueId(String token, String unique) {
        final Claims claims = JwtUtil.parseJWT(token, base64Secret);
        Integer uniqueId = (Integer) claims.get(unique);
        return uniqueId;
    }

}
