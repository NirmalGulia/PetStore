package api.endpoint;

public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	//user module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//pet module
	public static String post_pet_url=base_url+"/pet";
	public static String get_pet_url=base_url+"/pet/{petId}";
	public static String update_pet_url=base_url+"/pet/{petId}";
	public static String delete_pet_url=base_url+"/pet/{petId}";
	
	//store module
	public static String post_store_url=base_url+"/store/order";
	public static String get_store_url=base_url+"/store/order/{orderId}";
	public static String update_store_url=base_url+"/store/order/{orderId}";
	public static String delete_store_url=base_url+"/store/order/{orderId}";
}
