package com.naga.project.User.Controller;
import com.naga.project.User.DAO.Siteuser;
import com.naga.project.User.Service.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/list")
    public List<Siteuser> GetList(){
        return userService.getList();
    }

    @GetMapping("/user/create")
    public String CreateUser(@RequestParam String userid , @RequestParam String username , @RequestParam String password , @RequestParam String email, @RequestParam String tel){
        userService.createUser(userid,username,password,email,tel);
        return "생성완료";
    }

    @GetMapping("/user/getid")
    public List<Siteuser> GetUserId(@RequestParam String userid) {return userService.getId(userid);}


    @GetMapping("/user/login")
    public List<Siteuser> GetUser(@RequestParam String userid, @RequestParam String password) {
        List<Siteuser> U = userService.getUser(userid,password);
        return U;
    }

}
