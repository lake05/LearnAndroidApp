package com.example.learnandroidapp.entity;

public class User {
    public int id;
    public String name;
    public int age;
    public long height;
    public long weight;
    public boolean married;


    public User(String name, int age, long height, long weight, boolean married) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.married = married;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", married=" + married +
                '}';
    }
}
