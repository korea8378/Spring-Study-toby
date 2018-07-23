package com.toby.spring.common.config;

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
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("com.toby.spring")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())  // 현재 RequestMapping으로 할당된 모든 url 리스트 추출
                .paths(PathSelectors.ant("/**"))  // '/'로 시작하는 것만 문서화
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API-Study")
                .description("Spring API study")
                .termsOfServiceUrl("https://github.com/korea8378")
                .contact(new Contact("korea8378", "https://github.com/korea8378", "dlehdwns8556@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0")
                .build();
    }
}
