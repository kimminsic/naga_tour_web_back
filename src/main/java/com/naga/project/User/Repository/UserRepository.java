package com.naga.project.User.Repository;

import com.naga.project.User.DAO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
