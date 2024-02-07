package com.kitri.demo123.lesson.mybatis.todo_list;

import com.kitri.demo123.lesson.mybatis.dto.RequestTodo;
import com.kitri.demo123.lesson.mybatis.dto.ResponseTodo;
import com.kitri.demo123.lesson.mybatis.mappers.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    @Autowired
    TodoMapper todoMapper;

    @GetMapping
    public ArrayList<ResponseTodo> todos() {
        ArrayList<ResponseTodo> list =  (ArrayList<ResponseTodo>) todoMapper.findAll();
        return list;
    }
    @PostMapping
    public void add(@RequestBody RequestTodo todo) {
        todoMapper.save(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        todoMapper.deleteById(id);
    }

    @PutMapping
    public void put(@RequestBody RequestTodo todo){
        todoMapper.update(todo);
    }


}
