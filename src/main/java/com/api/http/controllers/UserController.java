package com.api.http.controllers;

import com.api.http.requests.SaveUserRequest;
import com.api.models.Roles;
import com.api.services.UserService;
import com.api.http.requests.UpdateUserRequest;
import com.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody SaveUserRequest request) {
        try {
            User user = makeUserToSave(request);
            return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            User user = userService.getById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateUserRequest request, @PathVariable Integer id) {
        try {
            User user = makeUserToUpdate(request);
            return new ResponseEntity<>(userService.update(user, id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("The update was not possible.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            userService.delete(id);
            return new ResponseEntity<>("The user was deleted.", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Something went wrong, please try again.", HttpStatus.BAD_REQUEST);
        }
    }

    protected User makeUserToSave(SaveUserRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .roleId(Roles.STUDENT)
                .password(request.getPassword())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }

    protected User makeUserToUpdate(UpdateUserRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .updatedAt(Instant.now())
                .build();
    }
}
