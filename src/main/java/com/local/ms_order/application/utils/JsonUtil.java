package com.local.ms_order.application.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.local.ms_order.domain.model.Order;

public class JsonUtil {

    public static String convertOrderToJson(Order order) {
        // Convierte el objeto Order a un JSON (puedes usar una librería como Jackson para esto)
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
