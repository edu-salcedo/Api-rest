package com.myresto.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myresto.rest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer > {

}
