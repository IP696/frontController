package com.example.froncontroller.components;


import com.example.froncontroller.components.handlers.BaseHandler;
import com.example.froncontroller.models.RequestHandle;
import com.example.froncontroller.models.RequestType;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class HandlersResolverImpl implements HandlersResolver {

    private Map<RequestType, BaseHandler> handlerMap = new HashMap<>();
    private Map<String, Object> beansWithAnnotation;
    private final ApplicationContext applicationContext;

    public HandlersResolverImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        beansWithAnnotation = applicationContext.getBeansWithAnnotation(RequestHandle.class);
        parse();
    }

    private void parse() {
        for (Map.Entry<String, Object> stringObjectEntry : beansWithAnnotation.entrySet()) {
            Object bean = stringObjectEntry.getValue();
            RequestHandle annotation = bean.getClass().getAnnotation(RequestHandle.class);
            RequestType[] types = annotation.types();
            for (RequestType type : types) {
                handlerMap.put(type, (BaseHandler) bean);
            }
        }
    }

    @Override
    public BaseHandler getHandler(RequestType type) {
        BaseHandler baseHandler = handlerMap.get(type);
        if (baseHandler == null) throw new IllegalArgumentException("Type not recognized");
        return baseHandler;
    }
}
