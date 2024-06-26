package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Tourist;

@RestController
@RequestMapping("/tourist")
public class TouristOperationController implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;


	@Override
	public void run(String... args) throws Exception {
	/*	//prepare serviceURL
		String serviceURL="http://localhost:8082/BootProj12-RestApp-MiniProject-OpenAPIDocs/tourist-api/register";
		//prepare header
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		//prepare JSON body
		String json_Body="{\"name\":\"sonu\",\"city\":\"delhi\",\"packageType\":\"laxory\",\"budget\":112233.0,\"startsFrom\":\"2024-03-06\",\"endsOn\":\"2024-04-15\"}";
		
		//create request as HttpEntity class obj having header, body
		HttpEntity<String> request=new HttpEntity<String>(json_Body, header);
		//create the POST mode request to call the method from producer API using RestTemplate
		ResponseEntity<String> response=template.exchange(serviceURL, HttpMethod.POST, request, String.class);
		//display the result
		System.out.println("Response body (result) :: "+response.getBody());
		System.out.println("Response ststus code :: "+response.getStatusCode());
		System.out.println("Response ststus code value :: "+response.getStatusCodeValue());
		*/
		System.out.println("===============================================");
		
		//prepare serviceURL  
		String serviceURL2="http://localhost:8082/BootProj12-RestApp-MiniProject-OpenAPIDocs/tourist-api/display";
		//create GET mode request to call method from producer app using RestTemplate
		ResponseEntity<String> response2=template.exchange(serviceURL2, HttpMethod.GET, null, String.class);
		System.out.println("Response body :: "+response2.getBody());
		System.out.println("Response status code :: "+response2.getStatusCode());
		//convert string as JSON content response into model  class obj
		ObjectMapper mapper=new ObjectMapper();
		List<Tourist> list=mapper.readValue(response2.getBody(), new TypeReference<List<Tourist>>() {});
				list.forEach(System.out::println);
				
				System.out.println("===============================================");
				
		//prepare the serviceURL
				String serviceURL3="http://localhost:8082/BootProj12-RestApp-MiniProject-OpenAPIDocs/tourist-api/findAll/{city1}/{city2}/{city3}";
				//create GET mode request to call method from producer app using RestTemplate
				ResponseEntity<String> response3=template.exchange(serviceURL3, HttpMethod.GET, null, String.class, "hyd","singapore","thailand");
				//convert the string JSON content to Model class obj using JACKSON API
				ObjectMapper mapper2=new ObjectMapper();
				List<Tourist> list2=mapper2.readValue(response3.getBody(), new TypeReference<List<Tourist>>() {});
				list2.forEach(System.out::println);
				
				System.out.println("===============================================");
				
				//prepare the serviceURL
						String serviceURL4="http://localhost:8082/BootProj12-RestApp-MiniProject-OpenAPIDocs/tourist-api/find/{tid}";
						//create GET mode request to call method from producer app using RestTemplate
						ResponseEntity<String> response4=template.exchange(serviceURL4, HttpMethod.GET, null, String.class, 1040);
						//convert the string JSON content to Model class obj using JACKSON API
						ObjectMapper mapper4=new ObjectMapper();
						Tourist tou=mapper2.readValue(response4.getBody(), Tourist.class);
						System.out.println("Tourist info ::"+tou);
						
						System.out.println("===============================================");
							
						//prepare serviceURL
						String serviceURL5="http://localhost:8082/BootProj12-RestApp-MiniProject-OpenAPIDocs/tourist-api/modify";
						//prepare the header for http request
						HttpHeaders header=new HttpHeaders();
						header.setContentType(MediaType.APPLICATION_JSON);
						//prepare body for http request
						String json_body="{ \"tid\":1022, \"name\":\"sonu\", \"city\":\"malayshia\", \"packageType\":\"business class\", \"budget\":35600.90, \"startsFrom\":\"2024-04-11\", \"endsOn\":\"2024-05-12\"}";
						//create Http request obj using HttpEntity class
						HttpEntity<String> request=new HttpEntity<String>(json_body, header);
						//call the method producer app using RestTemplate obj creating PUT mode req
						ResponseEntity<String> response=template.exchange(serviceURL5, HttpMethod.PUT, request, String.class);
						//display the response
						System.out.println("Response body::"+response.getBody());
						System.out.println("Response status code::"+response.getStatusCode());
						
						System.out.println("===============================================");
						
						//prepare the serviceURL
								String serviceURL6="http://localhost:8082/BootProj12-RestApp-MiniProject-OpenAPIDocs/tourist-api/findWithName/{tname}";
								//create GET mode request to call method from producer app using RestTemplate
								ResponseEntity<String> response6=template.exchange(serviceURL6, HttpMethod.GET, null, String.class, "sonu");
								//convert the string JSON content to Model class obj using JACKSON API
								ObjectMapper mapper6=new ObjectMapper();
								List<Tourist> list6=mapper6.readValue(response6.getBody(), new TypeReference<List<Tourist>>() {});
								list6.forEach(System.out::println);
								
								System.out.println("===============================================");
								/*
								//prepare the serviceURL
										String serviceURL7="http://localhost:8082/BootProj12-RestApp-MiniProject-OpenAPIDocs/tourist-api/remove/{tid}";
										//create GET mode request to call method from producer app using RestTemplate
										ResponseEntity<String> response7=template.exchange(serviceURL7, HttpMethod.DELETE, null, String.class, 1028);
										System.out.println("Response body ::"+response7.getBody());
										System.out.println("Response status code ::"+response7.getStatusCode());
										*/
									System.out.println("===============================================");
										/*
										//prepare the serviceURL
												String serviceURL8="http://localhost:8082/BootProj12-RestApp-MiniProject-OpenAPIDocs/tourist-api/delete/{start}/{end}";
												//create GET mode request to call method from producer app using RestTemplate
												ResponseEntity<String> response8=template.exchange(serviceURL8, HttpMethod.DELETE, null, String.class, 100000,115000);
												System.out.println("Response body ::"+response8.getBody());
												System.out.println("Response status code ::"+response8.getStatusCode());
												*/
										System.out.println("===============================================");
										
										//prepare serviceURL
										String serviceURL="http://localhost:8082/BootProj12-RestApp-MiniProject-OpenAPIDocs/tourist-api/pupdate/{tid}/{percent}";
										//create GET mode request to call method from producer app using RestTemplate
										ResponseEntity<String> response9=template.exchange(serviceURL, HttpMethod.PUT,  null, String.class, 1022, 4.0);
										System.out.println("Response body ::"+response9.getBody());
										System.out.println("Response status code ::"+response9.getStatusCode());    
	}

}
