package com.example.froncontroller.components.handlers;

import com.example.froncontroller.models.ExternalResponse;
import com.example.froncontroller.models.RequestHandle;
import com.example.froncontroller.models.RequestType;
import com.example.froncontroller.models.internal.FirstRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequestHandle(types = RequestType.FIRST)
@Component
public class FirstHandler implements BaseHandler {

    private final ObjectMapper mapper;

    public FirstHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ExternalResponse process(String request) throws IOException {
        FirstRequest firstRequest = mapper.readValue(request, FirstRequest.class);
        return new ExternalResponse("response: " + firstRequest.toString());
    }
}
