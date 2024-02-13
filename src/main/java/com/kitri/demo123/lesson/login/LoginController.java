package com.kitri.demo123.lesson.login;

import com.kitri.demo123.lesson.mybatis.dto.RequestUser;
import com.kitri.demo123.lesson.mybatis.dto.ResponseUser;
import com.kitri.demo123.lesson.mybatis.mappers.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserMapper userMapper;


    HashMap<String, Deta> User = new HashMap<>();

    @GetMapping
    public String show(){

        return "redirect:/login/login.html";
    }

    @GetMapping("/signup")
    public String sign(){
        return "redirect:/login/signup.html";
    }

    @GetMapping("/success")
    @ResponseBody
    public String success(){
        return "success good!!";
    }


    @GetMapping("/fail")
    @ResponseBody
    public String fail(){
        return "fail not good!!";
    }


    @GetMapping("/afterlogin")
    public String haha(){
        return "project/onlylogins";

    }

    @GetMapping("/logout1")
    public String logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        Boolean login = (Boolean) session.getAttribute("Login");
        if(login == null || !login){
            return "redirect:/login";
        }else{
            session.setAttribute("Login", false);
            return "redirect:/login";
        }
    }



    @PostMapping("/a")
    public String validate(@ModelAttribute Info info, HttpServletRequest request){
        if(info.getCheck() != null){

        }
        HttpSession session = request.getSession();
        ResponseUser user = userMapper.findByEmail(info.getEmail());
        if(user != null){
            if(Objects.equals(user.getPassword(), info.getPassword())){
                boolean login = true;
                session.setAttribute("Login", login);
                session.setAttribute("id", user.getId());
                session.setAttribute("name",user.getName());
                return "redirect:/todos";
            }
        }
        return "redirect:/login/fail";
    }

    @PostMapping
    public String readForm(@Valid SignUpDto form, BindingResult bindingResult){
        if(!Objects.equals(form.getPassword(), form.getPassword1()))
            return "redirect:/login/fail";
        if(bindingResult.hasErrors())
            return "redirect:/login/fail";
        ResponseUser user1 = userMapper.findByEmail(form.getEmail());
        if(user1 != null)
            return "redirect:/login/fail";
        RequestUser user = new RequestUser();
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setName(form.getName());
        userMapper.save(user);
        return "redirect:/login/login.html";
    }

}
