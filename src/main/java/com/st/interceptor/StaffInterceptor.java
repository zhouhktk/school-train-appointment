package com.st.interceptor;

import com.st.data.Code;
import com.st.exception.StaffException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义拦截器
 * @author : zhoufeng
 * @date : 2020/8/17
 */
public class StaffInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        Object staff = session.getAttribute("staff");
        if (staff!=null){
            return true;
        }
        //未登录时抛出异常，交由自定义异常处理程序处理
        throw new StaffException(Code.NOT_LOGIN, "未登录");
    }
}
