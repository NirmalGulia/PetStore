package api.endpoint;

import static io.restassured.RestAssured.given;

import api.payload.Store;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {

public static Response createOrder(Store payload) {
		
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(Routes.post_store_url);
				return response;
	}

public static Response readOrder(int orderId) {
		
		Response response=given()
				.accept(ContentType.JSON)
				.pathParam("orderId", orderId)
				.when()
				.get(Routes.get_store_url);
				return response;
	}

public static Response updateOrder(int orderId, Store payload) {
	
	Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("orderId", orderId)
			.body(payload)
			.when()
			.put(Routes.update_store_url);
			return response;
}

public static Response deleteOrder(int orderId) {
	
	Response response=given()
			.accept(ContentType.JSON)
			.pathParam("orderId", orderId)
			.when()
			.delete(Routes.delete_store_url);
			return response;
}
}
