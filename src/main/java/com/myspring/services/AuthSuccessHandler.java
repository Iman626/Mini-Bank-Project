package com.myspring.services;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler  {
    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
// Get the role of logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();


        String targetUrl = "";
        if(role.contains("ROLE_MANAGER")) {
            targetUrl = "/main";
        } else if(role.contains("ROLE_ADMIN")) {
            targetUrl = "/admin";
        }
        return targetUrl;
    }

}
