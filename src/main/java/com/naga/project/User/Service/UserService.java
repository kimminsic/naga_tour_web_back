package com.naga.project.User.Service;
import com.naga.project.User.DAO.User;
import com.naga.project.User.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getList() {
        return userRepository.findAll();
    }

    public void createUser(String userid, String username, String password, String email) {
        User U = new User();
        U.setUserid(userid);
        U.setUsername(username);
        U.setPassword(password);
        U.setEmail(email);
        userRepository.save(U);
    }
}
