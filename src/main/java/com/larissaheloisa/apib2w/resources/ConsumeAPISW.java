package com.larissaheloisa.apib2w.resources;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



public class ConsumeAPISW {

	public static Integer getAppearence(String name){
		try {
			Client c = Client.create();
		    WebResource wr = c.resource("https://swapi.dev/api/planets/?search=" + name);
		    ClientResponse response = wr.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		    if(response.getStatus() == 200) {
		    	String planets = response.getEntity(String.class);
		    	JSONObject jsonobj1 = new JSONObject(planets);
		    	JSONArray arr = new JSONArray(jsonobj1.get("results").toString());
		    	JSONObject jsonObj2 = new JSONObject(arr.get(0).toString());
		    	JSONArray arr2 = new JSONArray(jsonObj2.get("films").toString());
		    	//System.out.println(arr2.length());
		    	return arr2.length();
		    }   
		    
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
		
		return null;
	}
	
}
