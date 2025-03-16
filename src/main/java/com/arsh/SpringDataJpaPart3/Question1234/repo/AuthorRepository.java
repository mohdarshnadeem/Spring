package com.arsh.SpringDataJpaPart3.Question1234.repo;

import com.arsh.SpringDataJpaPart3.Question1234.entities.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findAll();
}
