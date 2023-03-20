package shoppingcart.server.models;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private String name;
    private String email;
    private List<LineItem> lineItems = new LinkedList<>();
    private String orderId;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public List<LineItem> getLineItems() {
        return lineItems;
    }
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
   

    
}
