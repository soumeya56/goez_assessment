package com.TravelSmileApp.GoEz.security.jwt;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;


@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);


    @Override
    public void commence(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, AuthenticationException authException) throws IOException, javax.servlet.ServletException {
        logger.error("Unauthorized error: {}", authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
    }
}