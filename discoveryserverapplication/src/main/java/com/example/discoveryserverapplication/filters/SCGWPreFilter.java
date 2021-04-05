package com.example.discoveryserverapplication.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class SCGWPreFilter extends AbstractGatewayFilterFactory<SCGWPreFilter.Config> {
    public SCGWPreFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        System.out.println("SCGWPreFilter here");
        return ((exchange, chain) -> {
            ServerHttpRequest build = exchange.getRequest().mutate().header("scgw-", Math.random() * 10 + "").build();
            return chain.filter(exchange.mutate().request(build).build());
        });
    }

    public static class Config {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
