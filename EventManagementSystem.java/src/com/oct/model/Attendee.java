package com.oct.model;
import java.io.Serializable;

/**
 * Handles attendee objects
 * 
 * @author Octavian Ionescu
 */
public class Attendee implements Serializable{
    private int id, age;
    private String name;
    public Attendee(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "ID : "+ this.id +". Attendee Name : " + this.name + " and is : " + this.age + " years old. ";
    }
}
