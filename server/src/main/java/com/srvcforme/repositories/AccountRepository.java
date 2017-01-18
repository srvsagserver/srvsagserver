package com.srvcforme.repositories;

import com.srvcforme.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Return the account with provided name
     *
     * @param name the account name.
     */
    Optional<Account> findByName(String name);


    /**
     * Return the account with provided id
     *
     * @param id the account id.
     */

    Optional<Account> findById(Long id);

}