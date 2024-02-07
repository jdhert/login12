package com.kitri.demo123.lesson.mybatis.todo_list;

public class Todo {
    int id;
    String todo;
    boolean done;

    public Todo(int id, String todo, boolean done) {
        this.id = id;
        this.todo = todo;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
