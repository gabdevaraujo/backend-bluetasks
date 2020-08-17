package com.bluetasks.bluetasksbackend.infrastructure.web.security;

public class SecurityConstants {

    public static final String SECRET_KEY = "tHeSeCrEtKey";
    public static final long EXPIRATION_TIME = 86400000; //1 DIA
    public static final String AUTHOTIZATION_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    
}