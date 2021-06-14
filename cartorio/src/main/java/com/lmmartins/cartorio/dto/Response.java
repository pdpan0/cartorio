package com.lmmartins.cartorio.dto;

import java.lang.reflect.Constructor;

/*
    Classe de transferência de dados.
*/
public class Response {
    private Boolean isSuccess;
    private Integer statusCode;
    private String errorMessage;
    private Long objectId;

//  Construtores
    public Response(Boolean isSuccess, Integer statusCode, String errorMessage) {
        this.isSuccess = isSuccess;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public Response(Boolean isSuccess, Integer statusCode, String errorMessage, Long objectId) {
        this.isSuccess = isSuccess;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.objectId = objectId;
    }

    //  Getters e Setters
    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

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
