package com.wyh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                /*这里标注controller的路径*/
                .apis(RequestHandlerSelectors.basePackage("com.wyh.system.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("新冠物资管理系统API文档")
                .description("新冠物资管理系统API文档")
                .termsOfServiceUrl("https://blog.csdn.net/QYHuiiQ?spm=1001.2101.3001.5113")
                .contact(new Contact("wyh","https://blog.csdn.net/QYHuiiQ?spm=1001.2101.3001.5113","wyhuii@126.com"))
                .version("1.0")
                .build();
    }
}