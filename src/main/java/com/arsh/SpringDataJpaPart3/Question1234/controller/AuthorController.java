package com.arsh.SpringDataJpaPart3.Question1234.controller;

import com.arsh.SpringDataJpaPart3.Question1234.entities.Author;
import com.arsh.SpringDataJpaPart3.Question1234.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {


    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/addAuthor")
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Author>> findAll(){
        return authorService.getAllAuthors();
    }
}
