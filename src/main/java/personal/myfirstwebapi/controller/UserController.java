package personal.myfirstwebapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.myfirstwebapi.model.User;
import personal.myfirstwebapi.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/users")
    public void post(@RequestBody User user) {
        repository.save(user);
    }

    @PutMapping("/users")
    public void put(@RequestBody User user) {
        repository.update(user);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return repository.listAll();
    }

    @GetMapping("/user/{id}")
    public User getOne(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.remove(id);
    }
}
