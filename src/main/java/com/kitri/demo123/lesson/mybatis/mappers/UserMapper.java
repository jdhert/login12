package com.kitri.demo123.lesson.mybatis.mappers;

import com.kitri.demo123.lesson.mybatis.dto.RequestTodo;
import com.kitri.demo123.lesson.mybatis.dto.RequestUser;
import com.kitri.demo123.lesson.mybatis.dto.ResponseTodo;
import com.kitri.demo123.lesson.mybatis.dto.ResponseUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<ResponseUser> findAll();

    ResponseUser findByEmail(String email);

    void save(RequestUser user);
}
