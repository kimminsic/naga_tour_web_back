package com.naga.project.Repository;

import com.naga.project.DAO.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;


public interface wishRepository extends JpaRepository<Wishlist, Integer> {
}
