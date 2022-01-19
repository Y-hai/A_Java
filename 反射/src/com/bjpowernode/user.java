package com.bjpowernode;

public class user {
    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public user() {
        System.out.println("user类的无参构造方法被执行");
    }

    public user(int n) {
        this.n = n;
    }
}
