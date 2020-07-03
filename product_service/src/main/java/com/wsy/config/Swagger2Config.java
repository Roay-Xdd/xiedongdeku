package com.wsy.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket  createRestApi(){

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wsy.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo(){

        //在文档最上方显示的基本信息
        return new ApiInfoBuilder()
                .title("供应链系统商品管理api接口")
                .description("供应链系统")
                .termsOfServiceUrl("")
                .version("1.0").build();

    }

}
