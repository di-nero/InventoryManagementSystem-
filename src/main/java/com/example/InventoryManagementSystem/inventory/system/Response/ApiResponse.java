package com.example.InventoryManagementSystem.inventory.system.Response;

import java.util.HashMap;
import java.util.Map;

public class apiResponse {
    public static Map<String, Object> responseBuilder(boolean success , String message , Object responseObject){
        Map<String , Object> response = new HashMap<>();
        response.put("Message" , message);
        response.put("Success" , success);
        response.put("Data" , responseObject);
        return response;
    }
}
