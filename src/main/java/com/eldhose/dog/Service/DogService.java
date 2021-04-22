package com.eldhose.dog.Service;

import com.eldhose.dog.Entity.DogModel;

import java.util.List;

public interface DogService {

        List<DogModel> retrieveDogs();

        void putDog(DogModel dog);

}
