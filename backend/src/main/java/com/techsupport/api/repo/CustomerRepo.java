package com.techsupport.api.repo;

import com.techsupport.api.models.Customer;
import com.techsupport.api.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends BasicPersonRepo<Customer>, CrudRepository<Customer, Long> {
}
