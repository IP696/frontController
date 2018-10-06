package com.example.froncontroller.components.handlers;

import com.example.froncontroller.models.ExternalResponse;

import java.io.IOException;

public interface BaseHandler {
    ExternalResponse process(String request) throws IOException;
}
