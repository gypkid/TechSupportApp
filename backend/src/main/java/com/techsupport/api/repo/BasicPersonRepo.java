package com.techsupport.api.repo;

import com.techsupport.api.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BasicPersonRepo<EntityType extends Person> extends CrudRepository<EntityType, Long> {
}
