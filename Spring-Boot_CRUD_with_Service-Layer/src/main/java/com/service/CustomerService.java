package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CustomerEntity;
import com.exception_custom.ConflictException;
import com.exception_custom.ResourceNotFoundException;
import com.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

//======================================================================================================================

	// Retrieve Operation:- Op:1A
	public List<CustomerEntity> getAllCustomers() {

		List<CustomerEntity> customer_list = customerRepo.findAll();
		LOGGER.info("Finding All Customers");

		if (customer_list.isEmpty()) {
			// return new ResponseEntity<>(HttpStatus.NO_CONTENT); // OR
			throw new ResourceNotFoundException("No data found");
		}

		LOGGER.info("List of All Customers");
		return customer_list;
	}

//======================================================================================================================

	// Retrieve data by Id :- Op:1B
	public CustomerEntity getCustomerById(Long customerId) {

		LOGGER.info("Finding Customer of Id: "+customerId);
		CustomerEntity customer = customerRepo.findById(customerId)
				  .orElseThrow(() -> new ResourceNotFoundException("Not found Customer with Id = " + customerId));

		LOGGER.info("Customer who's Id: "+customerId+", found Successfully...");
		// return customerRepo.findById(customerId).get();
		return customer;
	}

//======================================================================================================================

	// Retrieve data by Email :- Op:1C
	public CustomerEntity getCustomerByEmail(String customerEmail) {

		LOGGER.info("Finding Customer of Email: "+customerEmail);

		CustomerEntity customer = customerRepo.findByCustomerEmail(customerEmail);
		if(customer == null) {
			throw new ResourceNotFoundException("Not found Customer with Email = " + customerEmail);
		}
		LOGGER.info("Customer who's email: "+customerEmail+", found Successfully...");
		return customer;
	}

//======================================================================================================================

	//  Insert Operation by Id based on Email:-    Op:2
	public CustomerEntity addCustomer(CustomerEntity customerReq) {

		LOGGER.info("Trying to add Customer...");
		CustomerEntity customer = customerRepo.findByCustomerEmail(customerReq.getCustomerEmail());
		if(customer != null) {
			throw new ConflictException("Customer details didn't store...You have already Registered...");
		}

		LOGGER.info("Customer who's name "+customerReq.getCustomerName()+" added Successfully...");
		return customerRepo.save(customerReq);
	}

//======================================================================================================================

	//  Delete Operation by Id:-   Op:3
	public boolean deleteCustomerById(Long customerId) {

		LOGGER.info("Trying to Delete Customer of Id: "+customerId);

		CustomerEntity _customer = customerRepo.findById(customerId)
				  .orElseThrow(() -> new ResourceNotFoundException("Not found Customer with Id = " + customerId));

		customerRepo.deleteById(customerId);

		LOGGER.info("Customer Details who's Id: "+customerId+", Deleted Successfully..!!");
		return true;
	}

//======================================================================================================================

	//  Update Operation:-   Op:4 
	public CustomerEntity updateCustomer(CustomerEntity customerReq, Long customerId) {

		LOGGER.info("Trying to Update Customer of Id: "+customerId);
		CustomerEntity _customer = customerRepo.findById(customerId)
				  .orElseThrow(() -> new ResourceNotFoundException("Not found Customer with Id = " + customerId));

		_customer.setCustomerName(customerReq.getCustomerName());
	    _customer.setCustomerEmail(customerReq.getCustomerEmail());
	    _customer.setBillingAddress(customerReq.getBillingAddress());

	    LOGGER.info("Customer Details who's Id: "+customerId+", Upadted Successfully..!!"); 
		return customerRepo.save(_customer);
	}

//======================================================================================================================
//======================================================================================================================

 

	
}