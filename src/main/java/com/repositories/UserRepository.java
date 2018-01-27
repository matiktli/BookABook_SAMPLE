package com.repositories;

import com.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users",path="users")
public interface UserRepository extends MongoRepository<User,String>{

    User findByName(@Param("name") String name);
    User findByEmial(@Param("email") String email);
}
