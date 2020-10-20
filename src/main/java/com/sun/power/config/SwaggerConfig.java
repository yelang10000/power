package com.sun.power.config;

import com.sun.power.core.common.constant.SysConstant;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;

/**
 * @Author 贾涛
 * @Date 2020/10/15 13:51
 * @Version 1.0
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.OAS_30)
                .groupName("系统API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build().globalRequestParameters(getGlobalRequestParameters());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("管理端接口文档")
                .description("接口文档信息")
                .version("1.0")
                .build();
    }
    //生成全局通用参数
    private List<RequestParameter> getGlobalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("token")
                .description("平台token")
                .required(false)
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());
            return parameters;
    }

}
