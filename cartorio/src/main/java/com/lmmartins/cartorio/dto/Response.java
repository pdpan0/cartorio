package com.lmmartins.cartorio.dto;

import java.lang.reflect.Constructor;

/*
    Classe de transferência de dados.
*/
public class Response {
    private Integer statusCode;
    private String errorMessage;

//  Construtores
    public Response(Integer statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

//  Getters e Setters
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
