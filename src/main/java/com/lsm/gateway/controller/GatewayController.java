package com.lsm.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/gateway")
public class GatewayController {

    @RequestMapping(value = "/fallback", method = RequestMethod.GET)
    public Mono<String> fallback() {
        return Mono.just("service error, jump fallback");
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "welcome!";
    }
}
