package com.kitri.demo123.lesson.mybatis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUser {
    long id;
    String email;
    String password;
    String name;
}
