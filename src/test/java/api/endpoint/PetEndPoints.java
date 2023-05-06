package api.endpoint;

import static io.restassured.RestAssured.given;

import api.payload.Pet;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {

public static Response createUser(Pet payload) {
		
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(Routes.post_pet_url);
				return response;
	}

public static Response readUser(int petId) {
		
		Response response=given()
				.accept(ContentType.JSON)
				.pathParam("petId", petId)
				.when()
				.get(Routes.get_pet_url);
				return response;
	}

public static Response updateUser(int petId, Pet payload) {
	
	Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("petId", petId)
			.body(payload)
			.when()
			.put(Routes.update_pet_url);
			return response;
}

public static Response deleteUser(int petId) {
	
	Response response=given()
			.accept(ContentType.JSON)
			.pathParam("petId", petId)
			.when()
			.delete(Routes.delete_pet_url);
			return response;
}
}
