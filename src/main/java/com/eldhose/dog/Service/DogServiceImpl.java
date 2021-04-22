package com.eldhose.dog.Service;

import com.eldhose.dog.Entity.DogModel;
import com.eldhose.dog.Repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService{
    @Autowired
    DogRepository dogRepository;
    
    public List<DogModel> retrieveDogs() {
        return (List<DogModel>) dogRepository.findAll();
    }

    @Override
    public void putDog(DogModel dog) {
        dogRepository.save(dog);
    }
}
