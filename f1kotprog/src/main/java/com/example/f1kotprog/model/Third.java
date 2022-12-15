package com.example.f1kotprog.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Third {
    private String forname;
    private String surname;

    public Third(String forname, String surname){
        this.forname=forname;
        this.surname=surname;

    }
}
