package com.srvcforme.repositories;

import com.srvcforme.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Return the user with provided name
     *
     * @param name the user name.
     */
    List<User> findByName(String name);


    /**
     * Return the user with provided id
     *
     * @param id the user id.
     */

    Optional<User> findById(Long id);

}