package com.revature.main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.domain.ZipCodes;

public class ClientDriver {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/ZipCodeRestService/rest/zipcodes");
		
		//GET Request
		Builder getZipCodeBuilder = webTarget.path("33579").request();
		Response getZipCodeResponse = getZipCodeBuilder.accept(MediaType.APPLICATION_JSON).get();
		
		int statusCode = getZipCodeResponse.getStatus();
		System.out.println("Return with a status code: " + statusCode);
		ZipCodes z = getZipCodeResponse.readEntity(ZipCodes.class);
		System.out.println(z);
		
		System.out.println("********************************************************************************");
		
		//POST Request
		Builder postZipCodeBuilder = webTarget.request();
		z = new ZipCodes(28532, "Cherry Point", "North Carolina");
		
		Response postZipCodeResponse = 
				postZipCodeBuilder.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(z, MediaType.APPLICATION_JSON));
		
		statusCode = postZipCodeResponse.getStatus();
		System.out.println("Return with status code: " + statusCode);
		String s = postZipCodeResponse.readEntity(String.class);
		System.out.println(s);
	}

}
