package com.example.f1kotprog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Race {
        private int raceId;
        private int year;
        private int round;
        private int circuitId;
        private String name;
        private String date;


    public Race(int year, int round, int circuitId, String name, String date) {
        this.year = year;
        this.round = round;
        this.circuitId = circuitId;
        this.name = name;
        this.date = date;
    }
}
