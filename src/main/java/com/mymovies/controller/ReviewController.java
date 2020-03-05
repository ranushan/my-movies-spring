package com.mymovies.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

public class ReviewController {
	
	@Value("${resource.api.url}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	@RequestMapping(value = "/data/{movie_id}/reviews", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getAPI_Reviews(@PathVariable String movie_id) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String reviews = restTemplate.getForObject(BASE_URL+movie_id+"/reviews"+API_KEY+Language, String.class);
	
		return reviews;
		
	}

}
