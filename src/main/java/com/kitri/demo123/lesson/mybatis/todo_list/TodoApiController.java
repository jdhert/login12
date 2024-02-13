package com.kitri.demo123.lesson.mybatis.todo_list;

import com.kitri.demo123.lesson.mybatis.dto.RequestTodo;
import com.kitri.demo123.lesson.mybatis.dto.ResponseTodo;
import com.kitri.demo123.lesson.mybatis.mappers.TodoMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    @Autowired
    TodoMapper todoMapper;

    @GetMapping
    public ArrayList<ResponseTodo> todos(HttpServletRequest request) {
        HttpSession session = request.getSession();
        long id = (long) session.getAttribute("id");
        ArrayList<ResponseTodo> list =  (ArrayList<ResponseTodo>) todoMapper.findAll(id);
        return list;
    }
    @PostMapping
    public void add(@RequestBody RequestTodo todo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        long id = (long) session.getAttribute("id");
        todo.setUser_id(id);
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
