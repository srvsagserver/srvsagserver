package com.srvcforme.controllers;

import com.srvcforme.models.User;
import com.srvcforme.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequestMapping("/api")
@org.springframework.stereotype.Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * GET  /users : find users by provided criteria
     *
     * @param name user name
     * @return the ResponseEntity with status 200 (OK) and with List<User> of the users
     */

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "name", required = false) String name) {

        if (name != null) {
            return new ResponseEntity<>(userRepository.findByName(name).stream().collect(Collectors.toList()), HttpStatus.OK);
        }

        return new ResponseEntity<>(userRepository.findAll().stream().collect(Collectors.toList()), HttpStatus.OK);
    }

    /**
     * GET  /users/{id} : find user by id.
     *
     * @param id user id
     * @return the ResponseEntity with status 200 (OK) and with body of the user
     */

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getById(@PathVariable Long id) {

        return Optional.ofNullable(userRepository.findById(id)).
                map(user -> new ResponseEntity<>(user.get(), HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    /**
     * POST  /users : Create a new user.
     *
     * @param user the user to add
     * @return the ResponseEntity with status 201 (Created) and with body of the new user
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user) throws URISyntaxException {
//        TODO Add user (creator) check
        User result = userRepository.save(user);
        return ResponseEntity.created(new URI("/users/" + user.getId())).body(result);
    }

}
