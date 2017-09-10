package com.test.servlets;// Created by on 10.09.2017.

public class MyTimerTask {
    private int hours;
    private int minutes;
    private int seconds;

    public MyTimerTask(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String run() {
        String temp = "";
        if (hours == 0 && minutes == 0 && seconds == 0)
            temp = "The end!";
        else {
            temp = hours + ":" + minutes + ":" + seconds;
            decrement();
        }
        return temp;
    }

    public void decrement() {
        if (seconds > 0) seconds = seconds--;
        else if (minutes > 0) {
            minutes = minutes--;
            seconds = 59;
        } else {
            hours = hours--;
            minutes = 59;
            seconds = 59;
        }
    }
}
