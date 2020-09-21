package com.zxq.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter, Ordered {

    //这个是设置具体的过滤规则，设置请求地址必须带参数username，username不能为空
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if(username==null){
           log.info("用户名为null,非法用户，o(╥﹏╥)o");
           exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
           return  exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    //这个是设置过滤规则的优先级
    @Override
    public int getOrder() {
        return 0;
    }
}
