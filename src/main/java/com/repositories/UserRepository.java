package com.repositories;

import com.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "users",path="users")
public interface UserRepository extends MongoRepository<User,String>{

    Optional<User> findByName(@Param("name") String name); //TODO
    Optional<User> findBySurname(@Param("surname") String surname);
    Optional<User> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
    User findByEmail(@Param("email") String email);
    Boolean existsByEmail(@Param("email") String email);


}
