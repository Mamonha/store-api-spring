package com.example.demo.controllers;

import com.example.demo.enums.UserType;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> index(){
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> show(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> store(@RequestBody User user){
        try {
           User savedUser = userRepository.save(user);
           return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }catch (Exception err){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> existingUserOpt = userRepository.findById(id);

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setNome(updatedUser.getNome());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setDescricao(updatedUser.getDescricao());
            existingUser.setTelefone(updatedUser.getTelefone());
            existingUser.setIdade(updatedUser.getIdade());
            existingUser.setEndereco(updatedUser.getEndereco());
            existingUser.setFuncao(updatedUser.getFuncao());
            existingUser.setUserType(updatedUser.getUserType());


            User savedUser = userRepository.save(existingUser);

            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception err) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<List<User>> getEmployees(){
        List<User> users = userRepository.findByUserType(UserType.EMPLOYEE);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<User>> getCustomers(){
        List<User> users = userRepository.findByUserType(UserType.CUSTOMER);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/customers/age-range")
    public ResponseEntity<List<User>> getCustomersByAgeRange() {
        List<User> users = userRepository.findByUserTypeAndIdadeBetween(UserType.CUSTOMER, 18, 35);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
