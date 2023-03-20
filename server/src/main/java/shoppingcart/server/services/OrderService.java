package shoppingcart.server.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoppingcart.server.models.Order;
import shoppingcart.server.respositories.OrderRespo;

@Service
public class OrderService {
    @Autowired
    private OrderRespo orderRespo;

    public String createOrder(Order order) {
        String orderId = UUID.randomUUID().toString().substring(0, 8);
		order.setOrderId(orderId);
		orderRespo.createOrder(order);
		return orderId;
	}
}
