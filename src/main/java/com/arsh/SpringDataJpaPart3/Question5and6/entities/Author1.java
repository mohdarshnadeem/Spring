package com.arsh.SpringDataJpaPart3.Question5and6.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class Author1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Book1 book1;

}
