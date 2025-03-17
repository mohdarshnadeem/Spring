package com.arsh.SpringDataJpaPart3.Question7.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

//    bidirectional
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author2 author;

}
