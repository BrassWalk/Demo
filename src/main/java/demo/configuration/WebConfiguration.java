package demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void configureViewResolvers(final ViewResolverRegistry registry) {
        final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }

//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//        .allowedOrigins("http://localhost:3000", "http://localhost:8080");
//        .allowedOrigins("*");
//    }
}