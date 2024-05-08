package com.shookmaker.exercise.interceptor;

import com.alibaba.fastjson2.JSON;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.uitls.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        System.out.println("url:" + url);
        if (url.contains("login")
                || url.contains("register")
                || url.contains("swagger-ui")
                || url.contains("getAllIndustries")
                || url.contains("getJobsByIndustryId")
                || url.contains("answer")
        ) {
            return true;
        }
        String jwt = request.getHeader("Authorization");

        if (jwt == null || jwt.isEmpty()) {
            ResultBody resultNotLogin = ResultBody.error(401, "未登录");
            response.setStatus(401);
            response.getWriter().write(JSON.toJSONString(resultNotLogin));
            return false;
        }
        try {
            JwtUtil.parseJwt(jwt);
        } catch (Exception e) {
            ResultBody authorizationError = ResultBody.error(401, "Authorization已失效");
            response.setStatus(401);
            response.getWriter().write(JSON.toJSONString(authorizationError));
            return false;
        }
        return true;
    }
}
