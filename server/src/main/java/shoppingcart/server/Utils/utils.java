package shoppingcart.server.Utils;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import shoppingcart.server.models.LineItem;
import shoppingcart.server.models.Order;

public class utils {
    
    public static JsonObject toJson(LineItem lineItem) {
		return Json.createObjectBuilder()
			.add("item", lineItem.getItem())
			.add("quantity", lineItem.getQuantity())
			.build();
	}

	public static LineItem toLineItem(JsonObject j) {
		LineItem lineItem = new LineItem();
		lineItem.setItem(j.getString("item"));
		lineItem.setQuantity(j.getInt("quantity"));
		return lineItem;
	}

    public static JsonObject toJson(Order order) {
		JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
		order.getLineItems()
			.stream()
			.map(v -> toJson(v))
			.forEach(v -> {
				arrBuilder.add(v);
			});

		return Json.createObjectBuilder()
			.add("orderId", order.getOrderId())
			.add("name", order.getName())
			.add("email", order.getEmail())
			.add("lineItems", arrBuilder.build())
			.build();
	}

	public static Order toOrder(String json) {
		JsonReader reader = Json.createReader(new StringReader(json));
		return toOrder(reader.readObject());
	}
	public static Order toOrder(JsonObject json) {
		Order order = new Order();
		if (json.containsKey("orderId") && (!json.isNull("orderId")))
			order.setOrderId(json.getString("orderId"));
		order.setName(json.getString("name"));
		order.setEmail(json.getString("email"));
		List<LineItem> lineItems = json.getJsonArray("lineItems").stream()
            .map(v -> (JsonObject)v)
            .map(v -> toLineItem(v))
			.toList();
		order.setLineItems(lineItems);
		return order;
	}
}
