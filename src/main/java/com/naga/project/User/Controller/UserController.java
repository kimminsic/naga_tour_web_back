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

    //유저리스트 조회
    @GetMapping("/api/user/list")
    public List<Siteuser> GetList(){
        return userService.getList();
    }

    //유저 생성
    @GetMapping("/api/user/create")
    public String CreateUser(@RequestParam String userid , @RequestParam String username , @RequestParam String password , @RequestParam String email, @RequestParam String tel){
        userService.createUser(userid,username,password,email,tel);
        return "생성완료";
    }

    //유저아이디값을 통한 리스트 조회
    @GetMapping("/api/user/getid")
    public List<Siteuser> GetUserId(@RequestParam String userid) {return userService.getId(userid);}


    //유저이름을 통한 리스트 조회
    @GetMapping("/api/user/getName")
    public List<Siteuser> GetUserName(@RequestParam String username) { return userService.getUserName(username);}


    //유저의 모든정보를 통한 조회
    @GetMapping("/api/user/getUser")
    public List<Siteuser> GetUserInfo(@RequestParam String userid, @RequestParam String username, @RequestParam String email, @RequestParam String tel){
        return userService.getUserInfo(userid,username,email,tel);
    }

    // 유저 로그인
    @GetMapping("/api/user/login")
    public List<Siteuser> GetUser(@RequestParam String userid, @RequestParam String password) {
        List<Siteuser> U = userService.getUser(userid,password);
        return U;
    }

}
