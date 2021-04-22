package com.eldhose.dog.web;

import com.eldhose.dog.Entity.DogModel;
import com.eldhose.dog.Service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService)  {
        this.dogService = dogService;
    }

    @CrossOrigin(origins = "http://localhost:4200") // only allows requests from port 4200
    @GetMapping("/dog")
    public ResponseEntity<List<DogModel>> getAllDogs()
    {
        List<DogModel> list =dogService.retrieveDogs();
        return new ResponseEntity<List<DogModel>>(list,HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200") // only allows requests from port 4200
    @PostMapping("/dog")
    public void putDog(@RequestBody DogModel dog)
    {
        dogService.putDog(dog);
    }
}
