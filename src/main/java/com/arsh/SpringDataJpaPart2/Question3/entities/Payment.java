package com.arsh.SpringDataJpaPart2.Question3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


//@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "pmode",discriminatorType = DiscriminatorType.STRING)
@Entity
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Double amount;

}
