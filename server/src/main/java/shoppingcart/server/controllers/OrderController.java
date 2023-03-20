package shoppingcart.server.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import shoppingcart.server.Utils.utils;
import shoppingcart.server.models.Order;
import shoppingcart.server.services.OrderService;

@Controller
@RequestMapping(path="api/order",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class OrderController {
    @Autowired
    private OrderService orderSvc;
    
    private Logger logger = Logger.getLogger(OrderController.class.getName());
    
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postOrder(@RequestBody String payload){

        logger.info("New order: %s".formatted(payload));
        System.out.println("New order: %s".formatted(payload));

        Order order = utils.toOrder(payload);

        String orderId = orderSvc.createOrder(order);
        
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Json.createObjectBuilder()
                        .add("status", HttpStatus.CREATED.value())
                        .add("orderId", orderId)
                        .build().toString());
  
    }
}
