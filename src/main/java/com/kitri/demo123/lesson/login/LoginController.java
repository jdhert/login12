package com.kitri.demo123.lesson.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginController {

    HashMap<String, String> User = new HashMap<>();

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
        if(User.containsKey(info.getEmail())){
            if(Objects.equals(User.get(info.getEmail()), info.getPassword())) {
                boolean login = true;
                session.setAttribute("Login", login);
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
        if(User.containsKey(form.getEmail()))
            return "redirect:/login/fail";
        User.put(form.getEmail(), form.getPassword());
        return "redirect:/login/login.html";
    }

}
