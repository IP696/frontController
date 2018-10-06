package com.example.froncontroller.models;

import lombok.Data;

@Data
public class ExternalRequest {
    private RequestType type;
    private String request;
}
