package com.theironyard;


import org.springframework.data.repository.CrudRepository;

/**
 * Created by amalabukar on 1/9/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
