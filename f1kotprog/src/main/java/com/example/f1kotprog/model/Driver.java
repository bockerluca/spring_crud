package com.example.f1kotprog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Driver {
    private int driverId;
    private String number;
    private String forname;
    private String surname;
    private String dob;
    private String nationality;

    public Driver(String number, String forname, String surname, String dob, String nationality) {
        this.number = number;
        this.forname = forname;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
    }
}
