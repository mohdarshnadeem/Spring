package com.arsh.SpringDataJpaPart3.Question5and6.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(mappedBy = "book1", cascade = CascadeType.ALL)
    private Author1 author;
}
