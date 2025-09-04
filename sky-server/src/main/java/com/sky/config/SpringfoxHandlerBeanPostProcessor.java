package com.sky.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class SpringfoxHandlerBeanPostProcessor {

    @Bean
    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider) {
                    try {
                        Field field = bean.getClass().getDeclaredField("handlerMappings");
                        field.setAccessible(true);
                        @SuppressWarnings("unchecked")
                        List<RequestMappingInfoHandlerMapping> mappings =
                                (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                        List<RequestMappingInfoHandlerMapping> filtered =
                                mappings.stream()
                                        .filter(mapping -> mapping.getPatternParser() == null)
                                        .collect(Collectors.toList());
                        mappings.clear();
                        mappings.addAll(filtered);
                    } catch (Exception ignored) {
                        // 忽略反射异常，启动时不会影响其它功能
                    }
                }
                return bean;
            }
        };
    }
}