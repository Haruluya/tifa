//package com.tifa.framework.exceptions;
//
//import io.jsonwebtoken.SignatureException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
///**
// * 统一异常处理，全局捕获mvc抛出的异常。
// * @author haruluya.
// * @date 2022/4/9
// */
//@RestControllerAdvice
//public class PermissionHandler {
//    @ExceptionHandler(value = { SignatureException.class })
//    @ResponseBody
//    public ResultBO<?> authorizationException(SignatureException e){
//        return ResultTool.error(new ExceptionInfoBO(1008,e.getMessage()));
//    }
//}
