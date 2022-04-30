package com.dsmovie.repository;

import com.dsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    default User finByEmail(String email) {
        return null;
    }
}
