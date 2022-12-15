package com.example.f1kotprog.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class First {
    private String forname;
    private String surname;
    private  int mostP3Win;

    public First(String forname, String surname, int mostP3Win) {
        this.forname = forname;
        this.surname = surname;
        this.mostP3Win = mostP3Win;

    }
}
