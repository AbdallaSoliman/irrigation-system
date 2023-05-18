package com.banquemisr.irrigationsystem.message.config;

import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.i18n.*;
import org.springframework.context.support.*;
import org.springframework.validation.beanvalidation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.*;

import java.util.*;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Bean(name = "localeResolver")
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale(MessageConstant.DEFAULT_LOCALE_CODE)); // your default locale
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName(MessageConstant.INTERCEPTOR_PARAM_NAME);
        return localeChangeInterceptor;
    }

    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

    @Bean
    public MessageSourceAccessor getMessageSourceAccessor(final MessageSource messageSource) {
        LocaleContextHolder.setLocale(new Locale(MessageConstant.DEFAULT_LOCALE_CODE));
        return new MessageSourceAccessor(messageSource, new Locale(MessageConstant.DEFAULT_LOCALE_CODE));
    }

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource bundleMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("i18n/messages");
        return messageSource;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
    }

}
