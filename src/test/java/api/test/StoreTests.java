package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.StoreEndPoints;
import api.endpoint.UserEndPoints;
import api.payload.Store;
import api.payload.User;
import io.restassured.response.Response;

public class StoreTests {

	Faker faker;
	Store storepayload;
	
	@BeforeClass
	public void setup() {
		faker=new Faker();
		storepayload=new Store();
		/*int id;
		int petId;
		int quantity;
		String ShipDate;
		String Status;
		boolean complete;*/
		
		storepayload.setId(4);
		storepayload.setPetId(faker.idNumber().hashCode());
		storepayload.setQuantity(5);
		storepayload.setShipDate("2021-09-26T05:15:43.101+0000");
		storepayload.setStatus("placed");
		storepayload.setComplete(true);
		
	}
	
	@Test (priority=1)
	public void testPostOrder() {
		Response response=StoreEndPoints.createOrder(storepayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	}

	@Test (priority=2)
	public void testGetOrderByOrderId() {
		Response response=StoreEndPoints.readOrder(this.storepayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	}
	
	@Test (enabled=true,priority=3)
	public void testUpdateOrderByOrderId() {
		storepayload.setQuantity(15);
		storepayload.setStatus("approved");
		Response response=StoreEndPoints.updateOrder(this.storepayload.getId()), storepayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	}
	
	@Test (priority=4)
	public void testDeleteOrderById() {
		Response response=StoreEndPoints.deleteOrder(this.storepayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	}
}
