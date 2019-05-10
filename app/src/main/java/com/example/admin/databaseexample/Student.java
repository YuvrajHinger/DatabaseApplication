package com.example.admin.databaseexample;

public class Student {
    int id;
    String name;
    public Student(int id,String name){
        this.id = id;
        this.name = name;
    }
    public void  update(String name){
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
