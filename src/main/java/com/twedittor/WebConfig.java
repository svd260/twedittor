package com.twedittor;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sumanthdommaraju on 1/26/17.
 */
@Configuration
public class WebConfig{//} extends WebMvcConfigurerAdapter{

   // @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("resources/*").
//                addResourceLocations("/resources/*");
//    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(accessFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("accessFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean(name = "accessFilter")
    public Filter accessFilter() {
        return new Filter() {

                public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
                    System.out.println("Filtering on...........................................................");
                    HttpServletResponse response = (HttpServletResponse) res;
                    response.setHeader("Access-Control-Allow-Origin", "*");
                    response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
                    response.setHeader("Access-Control-Max-Age", "3600");
                    response.setHeader("Access-Control-Allow-Headers", "X-requested-with, Content-Type");
                    chain.doFilter(req, res);
                }

            public void init(FilterConfig filterConfig) {}

            public void destroy() {}
        };
    }
}
