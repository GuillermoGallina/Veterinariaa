package com.veterinaria.vet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(3600) // Puedes ajustar este valor según tus necesidades
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

    //Para las fechas
    // @Override
    // public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
    //     converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
    // }
}