package com.srvcforme.controllers;

import com.srvcforme.models.Account;
import com.srvcforme.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


@RequestMapping("/api")
@org.springframework.stereotype.Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * GET  /accounts?name=accountName : find account by name.
     *
     * @param name account name
     * @return the ResponseEntity with status 200 (OK) and with body of the account
     */

    @RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getByAccountName(@RequestParam(value = "name", required = true) String name) {
        return Optional.ofNullable(accountRepository.findByName(name)).
                map(account -> new ResponseEntity<>(account.get(), HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * GET  /accounts/{id} : find account by id.
     *
     * @param id account id
     * @return the ResponseEntity with status 200 (OK) and with body of the account
     */

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getById(@PathVariable Long id) {
        return Optional.ofNullable(accountRepository.findById(id)).
                map(account -> new ResponseEntity<>(account.get(), HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    /**
     * POST  /accounts : Create a new account.
     *
     * @param account the account to add
     * @return the ResponseEntity with status 201 (Created) and with body of the new account
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */

    @RequestMapping(value = "/accounts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) throws URISyntaxException {
//        TODO Add user (creator) check
        Account result = accountRepository.save(account);
        return ResponseEntity.created(new URI("/accounts/" + account.getId())).body(result);
    }

}
