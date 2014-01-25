package com.fan1tuan.test;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class WebserviceClientTest {
	public static void main(String[] args){
		Client client = Client.create();
		
		WebResource r = client.resource("http://localhost:8080/fan1tuan/webservice/rest/test/hello");
	
		String response = r.accept(
		        MediaType.TEXT_PLAIN_TYPE,
		        MediaType.APPLICATION_XML_TYPE).
		        header("X-FOO", "BAR").
		        get(String.class);
		
		System.out.println(response);
	}
}
