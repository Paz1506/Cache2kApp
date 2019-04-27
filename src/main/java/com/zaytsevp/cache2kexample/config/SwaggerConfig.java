package com.zaytsevp.cache2kexample.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Pavel Zaytsev
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
                                                               .paths(PathSelectors.any())
                                                               .build();

        docket.produces(Sets.newHashSet(APPLICATION_JSON_UTF8_VALUE));
        docket.consumes(Sets.newHashSet(APPLICATION_JSON_UTF8_VALUE));
        docket.useDefaultResponseMessages(false);

        return docket;
    }
}

