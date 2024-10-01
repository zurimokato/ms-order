package com.local.ms_order.application.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.local.ms_order.domain.model.Order;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {

    public static String convertOrderToJson(Order order) throws Exception {
        // Convierte el objeto Order a un JSON (puedes usar una librería como Jackson para esto)
        ObjectMapper mapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        try {
            return mapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
