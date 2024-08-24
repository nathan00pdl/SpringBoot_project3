package com.MyExample.Projeto3_Java_Spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.MyExample.Projeto3_Java_Spring.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
