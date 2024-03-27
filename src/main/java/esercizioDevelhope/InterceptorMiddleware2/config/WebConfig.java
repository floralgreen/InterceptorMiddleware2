package esercizioDevelhope.InterceptorMiddleware2.config;

import esercizioDevelhope.InterceptorMiddleware2.interceptors.MonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MonthInterceptor monthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(monthInterceptor);
    }



}
