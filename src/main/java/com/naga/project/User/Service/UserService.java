package com.naga.project.User.Service;
import com.naga.project.User.DAO.Siteuser;
import com.naga.project.User.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<Siteuser> getList() {
        return userRepository.findAll();
    }

    public void createUser(String userid, String username, String password, String email, String tel) {
        Siteuser U = new Siteuser();
        U.setUserid(userid);
        U.setUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        U.setPassword(passwordEncoder.encode(password));
        U.setEmail(email);
        U.setTel(tel);
        userRepository.save(U);
    }

    public boolean getPassword(String userid,String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        List<Siteuser> u = userRepository.findByUserid(userid);
        System.out.println("암호화 비밀번호"+u.get(0).getPassword());
        System.out.println("입력된 비밀번호"+password);
        if(u.size()!=0) {
            return encoder.matches(password, u.get(0).getPassword());
        }
        else {
            return false;
        }

    }


    public List<Siteuser> getUser(String userid, String password) {

        List<Siteuser> u = userRepository.findByUserid(userid);

        if(u.size()==0){
            return null;
        }
        if(getPassword(userid,password)){
            return userRepository.findByUserid(userid);
        }
        else{
            return null;
        }
    }

    public List<Siteuser> getId(String userid) {
        return userRepository.findByUserid(userid);
    }

    public List<Siteuser> getUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public List<Siteuser> getUserInfo(String userid, String username, String email, String tel) {
        return userRepository.findByUseridAndUsernameAndEmailAndTel(userid,username,email,tel);
    }
}
