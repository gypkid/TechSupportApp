package com.techsupport.api.repo;

import com.techsupport.api.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface PersonRepo extends BasicPersonRepo<Person>, CrudRepository<Person, Long> {
}
