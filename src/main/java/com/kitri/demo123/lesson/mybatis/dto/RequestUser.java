package com.kitri.demo123.lesson.mybatis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUser {
    long id = 0;
    String email;
    String password;
    String name;
}
