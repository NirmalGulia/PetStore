package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPoints;
import api.payload.Pet;
import api.payload.User;
import io.restassured.response.Response;

public class PetTests {

	Faker faker;
	Pet petpayload;
	
	@BeforeClass
	public void setup() {
		faker=new Faker();
		petpayload=new Pet();
		petpayload.setId(faker.idNumber().hashCode());
		petpayload.setUsername(faker.name().username());
		petpayload.setFirstName(faker.name().firstName());
		petpayload.setLastName(faker.name().lastName());
		petpayload.setEmail(faker.internet().safeEmailAddress());
		petpayload.setPassword(faker.internet().password(5,10));
		petpayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test (priority=1)
	public void testPostUser() {
		Response response=UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	}

	@Test (priority=2)
	public void testGetUserByName() {
		Response response=UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	}
	
	@Test (priority=3)
	public void testUpdateUserByName() {
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		Response response=UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	}
	
	@Test (priority=4)
	public void testDeleteUserByName() {
		Response response=UserEndPoints.deleteUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	}
}
