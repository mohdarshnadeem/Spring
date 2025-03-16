package com.arsh.SpringDataJpaPart2.Question3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

//@DiscriminatorValue("cc")
@Table(name = "card")
@PrimaryKeyJoinColumn(name = "id")
@Entity
public class CreditCard extends Payment {
    @Column(name = "card_number")
    private String cardNumber;

}
