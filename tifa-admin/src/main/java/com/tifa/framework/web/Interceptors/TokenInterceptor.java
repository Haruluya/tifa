//package com.tifa.framework.web.Interceptors;
//
//import com.tifa.framework.config.JwtConfig;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.SignatureException;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
///**
// * Token拦截器。
// * @author haruluya
// * @date 2022/4/9
// */
//@Component
//public class TokenInterceptor extends HandlerInterceptorAdapter {
//
//    @Resource
//    private JwtConfig jwtConfig ;
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response,
//                             Object handler) throws SignatureException {
//        /** 地址过滤 */
//        String uri = request.getRequestURI() ;
//        if (uri.contains("/user/login")){
//            return true ;
//        }
//        /** Token 验证 */
//        String token = request.getHeader(jwtConfig.getHeader());
//        if(StringUtils.isEmpty(token)){
//            token = request.getParameter(jwtConfig.getHeader());
//        }
//        if(StringUtils.isEmpty(token)){
//            throw new SignatureException(jwtConfig.getHeader()+ "Can`t be null!");
//        }
//
//        Claims claims = null;
//        try{
//            claims = jwtConfig.getTokenClaim(token);
//            if(claims == null || jwtConfig.isTokenExpired(claims.getExpiration())){
//                throw new SignatureException(jwtConfig.getHeader() + "time out,please login again!");
//            }
//        }catch (Exception e){
//            throw new SignatureException(jwtConfig.getHeader() + "time out,please login again!");
//        }
//
//        /** 设置 identityId 用户身份ID */
//        request.setAttribute("identityId", claims.getSubject());
//
//        return true;
//    }
//}