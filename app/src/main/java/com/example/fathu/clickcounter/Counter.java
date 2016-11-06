package com.example.fathu.clickcounter;

/**
 * Created by fathu on 16-Oct-16.
 */

public class Counter {
    private int counter = 0;


    public int getCounter(){
        return this.counter;
    }

    public void addCounter(){
        this.counter++;
    }

    public int resetCounter(){
        return this.counter = 0;
    }
}
