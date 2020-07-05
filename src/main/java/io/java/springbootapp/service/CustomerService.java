package io.java.springbootapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.java.springbootapp.Exception.InvalidEmailException;
import io.java.springbootapp.Exception.InvalidPasswordException;
import io.java.springbootapp.Exception.NotValidAgeException;
import io.java.springbootapp.Exception.UserExistException;
import io.java.springbootapp.Exception.UserNotFoundException;
import io.java.springbootapp.customer.Customer;
import io.java.springbootapp.repository.CustomerRepository;
import io.java.springbootapp.utility.CustomerValidationUtility;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	/**
	 * Add new customer
	 * 
	 * @param customer
	 * @throws InvalidEmailException 
	 * @throws InvalidPasswordException 
	 * @throws UserExistException 
	 * @throws NotValidAgeException 
	 */

	public void addNewUser(Customer customer) throws InvalidEmailException, InvalidPasswordException, UserExistException, NotValidAgeException{
		boolean isValidAge =CustomerValidationUtility.isValidAge(customer.getDob());
		if(!isValidAge)throw new NotValidAgeException("DOB less than 18 years");
		boolean isEmailExist=checkUserExistOrNot(customer.getEmail());
		if(isEmailExist)throw new UserExistException("Email id already exist");
		//User Email Validation
		boolean isValidemail=CustomerValidationUtility.isValidEmail(customer.getEmail());
		if(!isValidemail)throw new InvalidEmailException("User Email id not valid");
		//Password validation
		boolean isValidPassword=CustomerValidationUtility.isValidPassword(customer.getPassword());
		if(!isValidPassword)throw new InvalidPasswordException("User Password length must between 8 to 10");
		if(isValidemail&&isValidPassword){
			customerRepo.save(customer);
		}
		
		
	}

	/**
	 * get customer by id
	 * 
	 * @param id
	 * @return
	 * @throws UserExistException 
	 */
	public Customer getCustomerById(Long id) throws UserNotFoundException {
		if(customerRepo.findByID(id)==0){
			throw new UserNotFoundException("User Not Found");
		}
		return customerRepo.findOne(id);
	}

	/**
	 * Update Customer Details
	 * 
	 * @param customer
	 */

	public void updateCustomer(Customer customer) {
		customerRepo.save(customer);
	}

	/**
	 * Delete Customer Details by Id
	 * 
	 * @param id
	 */

	public void deleteCustomer(Long id) {
		customerRepo.delete(id);

	}

	/**
	 * get all customer
	 * @return
	 */
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepo.findAll();
	}
	
	/**
	 * get customer by emailid
	 * 
	 * @param id
	 * @return
	 */
	public boolean checkUserExistOrNot(String email) {
		if(customerRepo.findByEmailID(email)==1){
			return true;
		}
		return false;
	}
	
	
	
	

}
