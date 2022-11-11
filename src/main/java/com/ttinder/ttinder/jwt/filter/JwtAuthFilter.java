package com.ttinder.ttinder.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.jwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String accessToken = jwtUtil.getHeaderToken(request, "Access");

        if(accessToken != null){
            if(!jwtUtil.tokenValidation(accessToken)){
                jwtExceptionHandler(response);
                return;
            }
            setAuthentication(jwtUtil.getEmail(accessToken));
        }

        filterChain.doFilter(request,response);
    }

    public void setAuthentication(String email) {
        Authentication authentication = jwtUtil.createAuthentication(email);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public void jwtExceptionHandler(HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        try {
            String json = new ObjectMapper().writeValueAsString(ResponseDto.fails(HttpStatus.UNAUTHORIZED,"TOKEN이 만료되었습니다"));
            response.getWriter().write(json);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
