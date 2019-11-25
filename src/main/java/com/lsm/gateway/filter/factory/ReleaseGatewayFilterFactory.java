package com.lsm.gateway.filter.factory;


import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

/**
 * 自定义过滤器工厂
 */
public class ReleaseGatewayFilterFactory extends AbstractGatewayFilterFactory<ReleaseGatewayFilterFactory.Config> {

    /**
     * 必须调一下父类构造把Config类型传过去,否则会报ClassCastException异常
     */
    public ReleaseGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println(config.getName());
            System.out.println(config.isEnabled());
            if (!config.isEnabled()) {
                return chain.filter(exchange);
            }
            return chain.filter(exchange);
        };
    }

    /**
     * yml配置方式的自定义属性
     * 这里定义了一个enabled当做开关,可以在不修改代码,只修改yml配置文件的情况下使apply(Config config)方法内部走不同逻辑
     */
    public static class Config {
        private String name;
        private boolean enabled;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
