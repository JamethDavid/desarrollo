package com.example.desrrollo.util;

import org.springframework.http.HttpStatus;

public class RestResponse {
    private Integer responseCode;
    private String message;
    private Object body;

    public RestResponse(Integer resposeCode, String message) {
        this.responseCode = resposeCode;
        this.message = message;
    }


    public RestResponse(Integer responseCode, String message, Object body) {
        this.responseCode = responseCode;
        this.message = message;
        this.body = body;
    }


    public RestResponse(int TIPO_RESPONSE) {
        if (TIPO_RESPONSE == HttpStatus.UNAUTHORIZED.value()) {
            this.responseCode = HttpStatus.UNAUTHORIZED.value();
            this.message = HttpStatus.UNAUTHORIZED.getReasonPhrase();
            this.body = "Usuario no autenticado.";
        }
    }
    public RestResponse() {
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}

