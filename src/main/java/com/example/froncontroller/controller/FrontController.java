package com.example.froncontroller.controller;

import com.example.froncontroller.components.HandlersResolver;
import com.example.froncontroller.components.handlers.BaseHandler;
import com.example.froncontroller.models.ExternalRequest;
import com.example.froncontroller.models.ExternalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping
public class FrontController {

    private final HandlersResolver handlersResolver;

    public FrontController(HandlersResolver handlersResolver) {
        this.handlersResolver = handlersResolver;
    }

    @PostMapping("/request")
    public ExternalResponse externalRequest(@RequestBody ExternalRequest externalRequest) throws IOException {
        BaseHandler handler = handlersResolver.getHandler(externalRequest.getType());
        return handler.process(externalRequest.getRequest());
    }

    @RequestMapping("/test")
    public String test() {
        return "OK";
    }
}
