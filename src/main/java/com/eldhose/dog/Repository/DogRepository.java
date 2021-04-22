package com.eldhose.dog.Repository;

import com.eldhose.dog.Entity.DogModel;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<DogModel,Long> {

}
