package com.naga.project.wishlist.Repository;

import com.naga.project.wishlist.DAO.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface wishRepository extends JpaRepository<Wishlist, Integer> {
    List<Wishlist> findBycontentid(Integer contentid);

    @Transactional
   Optional<Wishlist> deleteBycontentid(Integer contentid);
}
