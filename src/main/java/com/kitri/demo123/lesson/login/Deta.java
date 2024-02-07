package com.kitri.demo123.lesson.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deta {
    String password;
    String name;

    public Deta() {
    }

    public Deta(String password, String name) {
        this.password = password;
        this.name = name;
    }
}
