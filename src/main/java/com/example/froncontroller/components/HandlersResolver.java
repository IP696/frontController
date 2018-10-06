package com.example.froncontroller.components;

import com.example.froncontroller.components.handlers.BaseHandler;
import com.example.froncontroller.models.RequestType;

public interface HandlersResolver {
    BaseHandler getHandler(RequestType type);
}
