package com.arsh.SpringDataJpaPart3.Question1234.entities;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int streetNumber;
    private String location;
    private String state;
}