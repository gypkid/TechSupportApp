package com.techsupport.api.repo;

import com.techsupport.api.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Long> {
}
