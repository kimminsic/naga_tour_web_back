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
        List<Siteuser> u = userRepository.findByUserid((userid));

        return encoder.matches(password,u.get(0).getPassword());

    }


    public List<Siteuser> getUser(String userid, String password) {
        BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
        List<Siteuser> u = userRepository.findByUserid(userid);
        if(u.size()==0){
            return null;
        }
        if(getPassword(userid,password)){
            return userRepository.findByUserid(userid);
        }

        return null;

    }
}
