package com.st.config;

import com.st.interceptor.StaffInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 * @author : zhoufeng
 * @date : 2020/8/17
 */
@Configuration
public class MyConfiger implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new StaffInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/staff/login");
    }
}
