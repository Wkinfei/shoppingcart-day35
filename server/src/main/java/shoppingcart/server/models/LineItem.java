package shoppingcart.server.models;

public class LineItem {
    private String item;
    private Integer quantity;
    
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
}
