package com.lsm.gateway.config;

import com.lsm.gateway.filter.factory.ReleaseGatewayFilterFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 路由配置
 */
@Configuration
public class RouteConfig {

    @Value("${user.server}")
    private String userServer;

    @Value("${app.server}")
    private String appServer;

    @Value("${gateway.server}")
    private String gatewayServer;

    /*@Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/user/**")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(userServer))
                .route(p -> p
                        .path("/app/**")
                        .uri(appServer))
                .route(p -> p.path("/test/fallback")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("gatewayServer")
                                        .setFallbackUri("forward:/gateway/fallback")))
                        .uri(gatewayServer))
                .build();
    }*/

    /**
     * 配置一个user服务路由,由自定义过滤器过滤
     *
     * @param builder
     * @return
     */
    /*@Bean
    public RouteLocator userRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/user/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri(userServer)
                        .order(0)
                        .id("user_filter_router")
                )
                .build();
    }*/

    /**
     * 向Srping Ioc容器注入自定义过滤器工厂
     *
     * @return
     */
    @Bean
    public ReleaseGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new ReleaseGatewayFilterFactory();
    }

}
