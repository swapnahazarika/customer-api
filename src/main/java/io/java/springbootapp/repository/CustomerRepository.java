package io.java.springbootapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.java.springbootapp.customer.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	@Query("Select COUNT (email) from Customer C where C.email =:id")
	int findByEmailID(@Param("id") String id);
	
	@Query("Select COUNT (id) from Customer C where C.id =:id")
	int findByID(@Param("id") Long id);

}
