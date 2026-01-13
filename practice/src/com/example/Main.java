package com.example;

import com.example.model.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("hoge");
        user.test();
        //完全限定ｸﾗｽ名
        com.example.utils.MathUtil math = new com.example.utils.MathUtil(1, 2);
        System.out.println(math);
    }
}
