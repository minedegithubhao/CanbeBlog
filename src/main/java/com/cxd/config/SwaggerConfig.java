package com.cxd.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author cxd
 * @description: Swagger2配置类
 * @create: 2022-06-26 06:51
 */
//@EnableWebMvc
//@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //扫描指定包中的swagger注解
////                .apis(RequestHandlerSelectors.basePackage("cn.cxd.controller"))
//                //扫描所有有注解的api，用这种方式更灵活
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    //http://127.0.0.1:8080/CanbeBlog/swagger-ui.html
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("网站的API文档")
//                .description("CanbeBlog | swagger")
//                .version("1.0")
//                .contact(new Contact("cxd","https://www.baidu.com","***@qq.com"))
//                .build();
//    }
}
