package com.naga.project.User.Controller;

import com.naga.project.User.DAO.User;
import com.naga.project.User.Service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/list")
    public List<User> GetList(){
        return userService.getList();
    }

    @GetMapping("/user/create")
    public String CreateUser(@RequestParam String userid , @RequestParam String username , @RequestParam String password , @RequestParam String email){
        userService.createUser(userid,username,password,email);
        return "생성완료";
    }
}
