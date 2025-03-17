package com.arsh.SpringDataJpaPart3.Question7.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Setter
public class Author2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

//  unidirectional
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "author_id")
//    private List<Book2> book2;

//  bidirectional
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book2> book2;

}
