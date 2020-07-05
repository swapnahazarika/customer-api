package io.java.springbootapp.controller.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.java.springbootapp.Exception.InvalidEmailException;
import io.java.springbootapp.Exception.InvalidPasswordException;
import io.java.springbootapp.Exception.NotValidAgeException;
import io.java.springbootapp.Exception.UserExistException;
import io.java.springbootapp.Exception.UserNotFoundException;
import io.java.springbootapp.controller.CustomerController;
import io.java.springbootapp.customer.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {
	
	@Mock
	private CustomerController customerController;
	
	@Before
    public void init() throws InvalidEmailException, InvalidPasswordException, UserExistException, NotValidAgeException {
		customerController.addCustomer(getCustomer());
    }
	@Test
	public void test_getCustomer() throws UserNotFoundException{
		Long id=new Long(1);
		Assert.notNull(customerController.getCustomer(id));
	}
	
	private Customer getCustomer(){
		Customer customer=new Customer();
		customer.setFirstname("XXXX");
		customer.setLastname("YYYYY");
		String dob="31/12/1998";  
	    Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		customer.setDob(date1);
		customer.setEmail("XXXX@xx.com");
		customer.setPassword("123456789");
		
		return customer;
		
		
	}

}
