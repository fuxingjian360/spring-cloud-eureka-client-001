package com.gupao.xing.jian.common.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gupao.xing.jian.common.exception.MyRuntimeException;
import com.gupao.xing.jian.common.util.ResultVO;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Type;

@RestControllerAdvice()
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        Type type = methodParameter.getGenericParameterType();
        String resType = type.getTypeName();
        if (!ResultVO.class.equals(resType)) {
            return true;
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        Type type = methodParameter.getGenericParameterType();
        if(String.class.equals(type)){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ResultVO<>(data));
            } catch (JsonProcessingException e) {
                throw new MyRuntimeException();
            }
        }
//        HttpHeaders httpHeaders = serverHttpResponse.getHeaders();
//        httpHeaders.set("head001","value001");
//        httpHeaders.set("head002","value002");
//        httpHeaders.set("head003","value003");

        return new ResultVO<>(data);
    }
}
