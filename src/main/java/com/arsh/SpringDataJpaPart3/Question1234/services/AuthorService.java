package com.arsh.SpringDataJpaPart3.Question1234.services;

import com.arsh.SpringDataJpaPart3.Question1234.entities.Author;
import com.arsh.SpringDataJpaPart3.Question1234.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public ResponseEntity<Author> saveAuthor(Author author){
        return new ResponseEntity<>(authorRepository.save(author), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        return ResponseEntity.ok(authors);  // Use HttpStatus.OK instead of FOUND
    }

}
