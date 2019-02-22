package com.grpc.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Description: 拦截器
 * Author: wzl
 * Version: 1.0
 * Create Date Time: 2018/9/21 15:09.
 *
 * @see
 */
@Component
public class InterceptorConfig implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

    /**
     * 进入controller层之前拦截请求
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("---------------------开始进入请求地址拦截----------------------------");
        return true;
//        HttpSession session = request.getSession();
//        if (!StringUtils.isEmpty(session.getAttribute("userName"))) {
//            return true;
//        } else {
//            PrintWriter printWriter = response.getWriter();
//            Map returnMessage = ReturnMessage.jsonData(false,"session is invalid,please login again!");
//            String tempJson = new JSONObject(returnMessage).toString();
//            printWriter.write(tempJson);
//            return false;
//        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("---------------视图渲染之后的操作-------------------------0");
    }
}
