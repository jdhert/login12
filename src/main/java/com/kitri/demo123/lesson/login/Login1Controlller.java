package com.kitri.demo123.lesson.login;

import com.kitri.demo123.lesson.mybatis.dto.RequestUser;
import com.kitri.demo123.lesson.mybatis.dto.ResponseUser;
import com.kitri.demo123.lesson.mybatis.mappers.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/login1")
public class Login1Controlller {


    @Autowired
    UserMapper userMapper;

    @PostMapping("/a")
    public String validate(@RequestBody Info info, HttpServletRequest request){
        HttpSession session = request.getSession();
        ResponseUser user = userMapper.findByEmail(info.getEmail());
        if(user != null){
            if(Objects.equals(user.getPassword(), info.getPassword())){
                boolean login = true;
                session.setAttribute("Login", login);
                session.setAttribute("id", user.getId());
                session.setAttribute("name",user.getName());
                if(info.getCheck() != null){
                    session.setAttribute("check", "true");
                    session.setAttribute("email", user.getEmail());
                }
                return "success";
            }
        }
        return "fail";
    }


    @PostMapping
    public String readForm(@Valid @RequestBody SignUpDto form){
        if(!Objects.equals(form.getPassword(), form.getPassword1()))
            return "fail";
//        if(bindingResult.hasErrors())
//            return "fail";
        ResponseUser user1 = userMapper.findByEmail(form.getEmail());
        if(user1 != null)
            return "fail";
        RequestUser user = new RequestUser();
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setName(form.getName());
        userMapper.save(user);
        return "success";
    }


    @GetMapping("/logcheck")
    public String logCheck(HttpServletRequest request){
        HttpSession session = request.getSession();
        Boolean login = (Boolean) session.getAttribute("Login");
        if(login == null || !login){
            return "fail";
        }else{
//            session.setAttribute("Login", false);
            return "true";
        }
    }

    @GetMapping("/logout1")
    public String logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        Boolean login = (Boolean) session.getAttribute("Login");
        if(login == null || !login){
            return "fail";
        }else{
           session.setAttribute("Login", false);
            return "true";
        }
    }
}
