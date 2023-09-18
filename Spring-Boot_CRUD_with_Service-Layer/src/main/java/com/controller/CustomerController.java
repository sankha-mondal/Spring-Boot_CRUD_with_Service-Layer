package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CustomerEntity;
import com.service.CustomerService;
import com.payload.ApiResponse;

@RestController
@RequestMapping("/customer") // http://localhost:8585/customer
public class CustomerController {

	@Autowired
	CustomerService customerService;

//======================================================================================================================

	// http://localhost:8585/customer/hello_world

	@GetMapping("/hello_world")
	public String getData() {
		return "Hello World";
	}

//======================================================================================================================

	// Retrieve Operation:- Op:1A
	// http://localhost:8585/customer/getAll

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllCustomers() {

		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.FOUND);
	}

//======================================================================================================================

	// Retrieve data by Id :- Op:1B
	// http://localhost:8585/customer/getById/{id}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> searchCustomerById(@PathVariable("id") Long customerId) {

		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.FOUND);
	}

//======================================================================================================================

	// Retrieve data by Email :- Op:1C
	// http://localhost:8585/customer/getByEmail/{email}

	@GetMapping("/getByEmail/{email}")
	public ResponseEntity<?> searchCustomerByEmail(@PathVariable("email") String email) {

		return new ResponseEntity<>(customerService.getCustomerByEmail(email), HttpStatus.FOUND);
	}

//======================================================================================================================

	//  Insert Operation:-    Op:2
	//  http://localhost:8585/customer/addCustomer

	@PostMapping(value="/addCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addCustomer(@RequestBody CustomerEntity customerReq) {

		System.out.println(customerReq.getCustomerEmail());
		return new ResponseEntity<>(customerService.addCustomer(customerReq),HttpStatus.CREATED);
	}

//======================================================================================================================

	  //  Delete Operation by Id:-   Op:3
	  //  http://localhost:8585/customer/deleteCustomer/{customerId}

	  @DeleteMapping("/deleteCustomer/{customerId}")
	  public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable("customerId") Long customerId) {

		  boolean customer = customerService.deleteCustomerById(customerId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Customer details deleted Successfully", true), HttpStatus.OK);
	  }

//======================================================================================================================

	  //  Update Operation:-   Op:4  
	  //  http://localhost:8585/customer/updateCustomer/{customerId}

	  @PutMapping("/updateCustomer/{customerId}")
	  public ResponseEntity<?> updateCustomer(@PathVariable("customerId") Long customerId, 
			  								  @RequestBody CustomerEntity customerReq) {

	    return new ResponseEntity<>(customerService.updateCustomer(customerReq, customerId), HttpStatus.CREATED);
	  }

//======================================================================================================================
//======================================================================================================================

	
}
