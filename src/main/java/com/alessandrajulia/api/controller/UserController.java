package com.alessandrajulia.api.controller;

import com.alessandrajulia.api.model.User;
import com.alessandrajulia.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getOne(@PathVariable("id") Long id){
        Optional<User> userFind = userRepository.findById(id);
        if(userFind.isPresent()){
            return userFind.get();
        }
        return null;
    }

    @GetMapping("/findByName/{name}")
    public List<User> findByName(@PathVariable("name") String name){
        return userRepository.findByNameIgnoreCase(name);
    }

    @GetMapping("/list")
    public List<User> listar(){
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus
    public User cadastrar(@RequestBody User user){
        return  userRepository.save(user);
    }

    @DeleteMapping
    @ResponseStatus
    public void deletar(@RequestBody User user){
        userRepository.delete(user);
    }
}
