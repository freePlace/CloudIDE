package org.freeplace.cloudide.configuration;

import org.freeplace.cloudide.applicationinfo.ApplicationData;
import org.freeplace.cloudide.applicationinfo.FileExtension;
import org.freeplace.cloudide.applicationinfo.Path;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = ApplicationData.APPLICATION_FULL_NAME)
public class AppConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(Path.VIEWS);
        viewResolver.setSuffix(FileExtension.JSP);
        return viewResolver;
    }
}