package com.ijse.IjsePos.repository;

import com.ijse.IjsePos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u from User u WHERE u.username=:username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query()
    Boolean existsByUsername(String username);

    @Query
    Boolean existsByEmail(String email);
}
