package shoppingcart.server.respositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import jakarta.json.JsonObject;
import shoppingcart.server.Utils.utils;
import shoppingcart.server.models.Order;

@Repository
public class OrderRespo {
    @Autowired
	private MongoTemplate mongoTemplate;

    public void createOrder(Order order) {
		JsonObject j = utils.toJson(order);
		Document doc = Document.parse(j.toString());

		mongoTemplate.insert(doc, "orders");
	}
}
