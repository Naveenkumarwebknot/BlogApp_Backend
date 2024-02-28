//package com.example.Blog.Backend.error;
//
//import dto.ApiResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//
//
//@RestControllerAdvice
//public class GlobalExceptionhandler {
//
//    @ExceptionHandler(BlogNotFoundException.class)
//    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(BlogNotFoundException exception) {
//        String message = exception.getMessage();
//        ApiResponse apiResponse = ApiResponse.builder()
//                .message(message)
//                .status(HttpStatus.NOT_FOUND)
//                .success(true)
//                .build();
//
//        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
//    }
//}
