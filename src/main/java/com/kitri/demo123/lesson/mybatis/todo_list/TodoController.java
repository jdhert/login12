package com.kitri.demo123.lesson.mybatis.todo_list;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todos")
public class TodoController {
    @GetMapping
    public String todos() {
        return "project/todo_list/todo";
    }
}
