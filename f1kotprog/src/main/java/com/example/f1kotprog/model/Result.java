package com.example.f1kotprog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Result {
    private int resultId;
    private int raceId;
    private int driverId;
    private String number;
    private int grid;
    private int positionOrder;
    private int points;



    public Result(int raceId, int driverId, String number, int grid, int positionOrder, int points) {
        this.raceId = raceId;
        this.driverId = driverId;
        this.number = number;
        this.grid = grid;
        this.positionOrder = positionOrder;
        this.points = points;
    }
}
