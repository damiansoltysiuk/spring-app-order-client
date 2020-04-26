package com.sda.springapporderclient.repository;

import com.sda.springapporderclient.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value= "SELECT * FROM users u WHERE LOWER(u.first_name) LIKE LOWER(CONCAT('%',:firstName,'%')) AND LOWER(u.last_name) LIKE LOWER(CONCAT('%',:lastName,'%'))", nativeQuery = true)
    Optional<List<User>> findUserByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query(value = "SELECT * FROM users u WHERE LOWER(u.username) LIKE LOWER(:username)", nativeQuery = true)
    Optional<User> findUserByUsername(@Param("username") String username);
}
