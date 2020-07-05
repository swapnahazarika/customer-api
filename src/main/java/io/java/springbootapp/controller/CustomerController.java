package io.java.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.java.springbootapp.Exception.InvalidEmailException;
import io.java.springbootapp.Exception.InvalidPasswordException;
import io.java.springbootapp.Exception.NotValidAgeException;
import io.java.springbootapp.Exception.UserExistException;
import io.java.springbootapp.Exception.UserNotFoundException;
import io.java.springbootapp.customer.Customer;
import io.java.springbootapp.service.CustomerService;


@RestController	
public class CustomerController {

	@Autowired
	private CustomerService customerservice;
	
	@RequestMapping("/api/getAllCustomers")
	public List<Customer>getAllCustomer(){
		return customerservice.getAllCustomer();
		
	}

	@RequestMapping(method = RequestMethod.GET, value="/api/customer/{id}")
	public Customer getCustomer(@PathVariable Long id) throws UserNotFoundException {
		return customerservice.getCustomerById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/customer")
	@ResponseStatus(HttpStatus.CREATED) 
	public void addCustomer(@RequestBody Customer customer) throws InvalidEmailException, InvalidPasswordException, UserExistException, NotValidAgeException {
		System.out.print(customer.toString());
		customerservice.addNewUser(customer);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/api/customer")
	public void updateCourse(@RequestBody Customer customer) {
		customerservice.updateCustomer(customer);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/api/customer/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerservice.deleteCustomer(id);
	}

}
