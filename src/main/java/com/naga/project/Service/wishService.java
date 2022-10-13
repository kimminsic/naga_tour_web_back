package com.naga.project.Service;

import com.naga.project.DAO.Wishlist;
import com.naga.project.Repository.wishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class wishService {

    private final wishRepository wishRepository;

    public List<Wishlist> findWishlist(){
        return wishRepository.findAll();
    }

    public void create(String title, String addr1, String img,String tel, Integer contentid, Integer contenttypeid){
        Wishlist w = new Wishlist();
        w.setTitle(title);
        w.setAddr1(addr1);
        w.setImg(img);
        w.setTel(tel);
        w.setContentid(contentid);
        w.setContenttypeid(contenttypeid);
        wishRepository.save(w);
    }

    public List<Wishlist> findWIshlistItem(Integer contentid) {
       return wishRepository.findBycontentid(contentid);
    }


}
