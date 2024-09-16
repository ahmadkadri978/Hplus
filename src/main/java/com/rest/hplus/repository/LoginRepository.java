package com.rest.hplus.repository;

import com.rest.hplus.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<User, Integer> {
    @Query("select u from User u where u.username = :username")
    User findByUsername(@Param("username") String username);
}
