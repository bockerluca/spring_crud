package com.example.f1kotprog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Circuit {
    private int circuitId;
    private String name;
    private String location;
    private String country;

    public Circuit (String name, String location, String country) {
        this.name = name;
        this.location = location;
        this.country = country;
    }

}
