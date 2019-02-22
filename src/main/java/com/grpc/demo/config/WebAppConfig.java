package com.grpc.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Description: 自定义拦截器
 * Author: wzl
 * Version: 1.0
 * Create Date Time: 2018/9/21 15:15.
 *
 * @see
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //这里可以添加多个拦截器
		registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**");
		super.addInterceptors(registry);

    }
}
