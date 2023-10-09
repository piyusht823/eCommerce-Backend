package com.ecommerce.dao;

import com.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

    // Custom query methods, if needed
    //User findByUsername(String username);
}
