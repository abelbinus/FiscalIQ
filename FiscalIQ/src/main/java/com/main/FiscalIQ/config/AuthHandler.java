package com.main.FiscalIQ.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.security.auth.login.LoginException;

/**
 * Interceptor class that implements the {@link HandlerInterceptor} interface to provide
 * pre- and post-processing of requests. Specifically, it checks for a valid user session
 * before allowing access to protected resources.
 * <p>
 * This interceptor ensures that only authenticated users can access certain parts of the
 * application, enforcing security at the application level.
 */
@Component
public class AuthHandler implements HandlerInterceptor, WebMvcConfigurer {


    public static final String HEAD_KEY = "AUTHORIZATION";

    // Autowires an instance of MyInterceptor to be used within this configuration.
    @Autowired
    private AuthHandler authInterceptor;

    private Authorization authorization;


    public String authenticate(String userName, String password) {
        int userId = 1;
        return authorization.authorize(userId);
    }


    /**
     * Pre-processes each request before the corresponding controller handler method is executed.
     * <p>
     * This method checks for the existence of a session and a specific session attribute
     * to verify that the user is logged in. If the check fails, it throws a {@link LoginException},
     * effectively blocking the request from proceeding.
     *
     * @param request  the current request
     * @param response the current response
     * @param handler  the chosen handler to execute, for type and/or instance evaluation
     * @return {@code true} to proceed with the handler execution; {@code false} to abort
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }

    /**
     * Post-processes each request after the corresponding controller handler method has been executed,
     * but before the view is rendered.
     * <p>
     * For demonstration purposes, this method simply logs a message indicating that post-processing
     * has occurred.
     *
     * @param request      the current request
     * @param response     the current response
     * @param handler      the chosen handler to execute
     * @param modelAndView the ModelAndView that the handler returned
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    /**
     * Callback after completion of request processing, that is, after rendering the view.
     * <p>
     * Can be used for cleanup actions. For demonstration purposes, this method simply logs
     * a message indicating that the request has fully completed.
     *
     * @param request  the current request
     * @param response the current response
     * @param handler  the chosen handler to execute
     * @param ex       any exception that has been thrown during request processing
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }

    /**
     * Callback method to register interceptors for pre- and post-processing of controller method invocations and resource handler requests.
     * <p>
     * Registers {@link AuthHandler} to intercept requests matching "/api/**" path patterns,
     * except for requests to "/api/login/signin", which are explicitly excluded from interception.
     * This setup is useful for applying common logic, such as authentication and logging, to a subset of incoming requests.
     * </p>
     *
     * @param registry The interceptor registry where interceptor definitions are registered.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/**").excludePathPatterns("/api/authentication/login");
    }
}