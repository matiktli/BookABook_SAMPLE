package com.repositories;

import com.models.Book;
import com.models.enums.BookType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "bookRepo",path="bookRepo")
public interface BookRepository extends MongoRepository<Book,String>{

    List<Book> findByAuthor(@Param("author") String author);
    List<Book> findByType(@Param("type") BookType bookType);
    List<Book> findBookByGroupsContains(@Param("group") List<String> group);

    Book findByTitle(@Param("title") String title);
    List<Book> findByTitleOrAuthor(String title,String author);


}
