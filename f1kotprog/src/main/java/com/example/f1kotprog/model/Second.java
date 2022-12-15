package com.example.f1kotprog.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Second {
    private String name;
    private String location;
    private String country;
    private int countOfRaces;

    public Second(String name, String location, String country, int countOfRaces){
        this.name=name;
        this.location=location;
        this.country=country;
        this.countOfRaces=countOfRaces;
    }
}
