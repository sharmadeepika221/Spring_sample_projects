package com.sample.demo.controller;

import com.sample.demo.model.Users;
import com.sample.demo.repository.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserJpaRespository userJpaRespository;

    @GetMapping(value = "/all")
    public List<Users> findAll() {
        return userJpaRespository.findAll();
    }

    @GetMapping(value = "/{name}")
    public Users findByName(@PathVariable final String name){
        return userJpaRespository.findByName(name);
    }

    @PostMapping(value = "/load")
    public Users load(@RequestBody final Users users) {
        userJpaRespository.save(users);
        return userJpaRespository.findByName(users.getName());
    }
}
