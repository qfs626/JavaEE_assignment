package com.example.api.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.*;

public final class JwtTokenUtil {

    //在http header中的名字
    public final static String TOKEN_HEADER = "Authorization";

    //一个星期过期
    public final static long REMEMBER_EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7;

    //一天过期
    public final static long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    // 应用密钥
    private static final String APP_SECRET = "logistics.api";

    private static final String PREFIX = "logistics:";

    // 角色权限声明
    private static final String ROLE_CLAIMS = "roles";

    //检验token是否合法
    public static boolean checkToken(String token) {
        if ("null".equals(token) || token == null || "".equals(token)) {
            return false;
        }
        return token.startsWith(PREFIX);
    }

    /**
     * 生成Token
     */
    public static String createToken(String username, String[] roles, long expiration) {
        for(String i:roles){
            System.out.println("username: "+username+"createToken: "+i);
        }
        Map<String, Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, roles);
        return PREFIX + Jwts.builder()
                .setSubject(username)
                .setClaims(map)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
    }

    /**
     * 获取token body
     */
    private static Claims  getTokenClaims(String token) {
        token = token.substring(PREFIX.length());
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(APP_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        }
        return claims;
    }

    /**
     * 从Token中获取username
     */
    public static String getUsername(String token) {
        return getTokenClaims(token).getSubject();
    }

    /**
     * 从Token中获取用户角色
     */
    public static List<String> getTokenRoles(String token) {
        List<String> roles = new ArrayList<>();
        Object object = getTokenClaims(token).get(ROLE_CLAIMS);
        if (object instanceof ArrayList<?>) {
            for (Object o : (List<?>) object) {
                roles.add((String) o);
            }
        }
        return roles;
    }

    /**
     * 校验Token是否过期
     */
    public static boolean isExpiration(String token) {
        return getTokenClaims(token).getExpiration().before(new Date());
    }

}

