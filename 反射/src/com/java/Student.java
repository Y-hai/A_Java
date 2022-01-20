package com.java;

public class Student {
    // Field代表字段
    public int no;
    private String name;
    protected int age;
    boolean sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(int no, String name, int age, boolean sex) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
