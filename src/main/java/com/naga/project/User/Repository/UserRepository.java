package com.naga.project.User.Repository;

import com.naga.project.User.DAO.Siteuser;
import com.naga.project.wishlist.DAO.Wishlist;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Siteuser,Integer> {

    List<Siteuser> findByUseridAndPassword(String userid, String password);

  List<Siteuser>  findByUserid(String userid);


}
