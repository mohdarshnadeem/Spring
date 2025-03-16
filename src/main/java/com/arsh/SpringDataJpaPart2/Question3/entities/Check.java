package com.arsh.SpringDataJpaPart2.Question3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@DiscriminatorValue("ch")
@Table(name="bank_check")
@PrimaryKeyJoinColumn(name = "id")
@Entity
public class Check extends Payment {
    @Column(name = "check_number")
    private String checkNumber;

}
