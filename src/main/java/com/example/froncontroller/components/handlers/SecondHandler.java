package com.example.froncontroller.components.handlers;

import com.example.froncontroller.models.ExternalResponse;
import com.example.froncontroller.models.RequestHandle;
import com.example.froncontroller.models.RequestType;
import com.example.froncontroller.models.internal.SecondRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequestHandle(types = RequestType.SECOND)
@Component
public class SecondHandler implements BaseHandler {

    private final ObjectMapper mapper;

    public SecondHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ExternalResponse process(String request) throws IOException {
        SecondRequest secondRequest = mapper.readValue(request, SecondRequest.class);
        return new ExternalResponse("response: " + secondRequest.toString());
    }
}
