package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristMgmtService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tourist-api")
@Tag(name="Tourist", description = "Tourist operation controller")
public class TouristOperationsController {
	@Autowired
	private ITouristMgmtService touristService;
	
	@PostMapping("/register")
	@Operation(summary = "Save the tourist", description = "Insert the tourist info")
	@ApiResponses(value= {@ApiResponse(responseCode = "201",description = "successful operation-created")})
	public ResponseEntity<?> enrollTourist(@RequestBody Tourist tourist){
		
		try {
			//user Service
			String resultMsg=touristService.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
		}//try
		catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method
	
	@GetMapping("/display")
	public ResponseEntity<?> displayTourists(){
		try {
			//use service
			List<Tourist> list=touristService.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching tourist", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll/{city1}/{city2}/{city3}")
	public ResponseEntity<?> fetchTouristByCities(@PathVariable(required = false) String city1, 
			                                                                                 @PathVariable (required = false) String city2,
			                                                                                 @PathVariable (required = false) String city3){
		try {
			List<Tourist> list=touristService.showAllTourist(city1, city2, city3);
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{tid}")
	public ResponseEntity<?> displayTouristById(@PathVariable(name ="tid") Integer id){
		try {
			//user service
			Tourist tourist=touristService.findTouristById(id);
			return new ResponseEntity<Tourist> (tourist, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist){
		try {
			//use service
			String rusultMsg=touristService.updateTouristDetails(tourist);
			return new ResponseEntity<String>(rusultMsg, HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findWithName/{tname}")
	public ResponseEntity<?> findTouristsByName(@PathVariable(name="tname") String name){
		try {
			//use service
			List<Tourist> list=touristService.getAllTouristByName(name);
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//@PatchMapping("/pupdate/{tid}/{percent}")
	@PutMapping("/pupdate/{tid}/{percent}")
	public ResponseEntity<String> modifyTouristBudgetDetailsByid(@PathVariable (name="tid") int id, 
			                                                                                                                  @PathVariable double percent){
		try {
			//use service
			String msg=touristService.updateTouristBudgetById(id, percent);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeTouristById(@PathVariable int id){
		try {
			//use service
			String msg=touristService.removeTouristById(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("delete/{start}/{end}")
	public ResponseEntity<String> deleteTouristByBudgetRange(@PathVariable double start, @PathVariable double end){
		try {
			//use service
			String msg=touristService.removeTouristByBudgetRange(start, end);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
