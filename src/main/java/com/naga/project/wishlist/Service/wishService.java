package com.naga.project.wishlist.Service;

import com.naga.project.wishlist.DAO.Wishlist;
import com.naga.project.wishlist.Repository.wishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class wishService {

    private final wishRepository wishRepository;

    public List<Wishlist> findWishlist(){
        return wishRepository.findAll();
    }

    public void create(String title, String addr1, String img,String tel, Integer contentid, Integer contenttypeid, String userId){
        Wishlist w = new Wishlist();
        w.setTitle(title);
        w.setAddr1(addr1);
        w.setImg(img);
        w.setTel(tel);
        w.setContentid(contentid);
        w.setUserId(userId);
        w.setContenttypeid(contenttypeid);

        wishRepository.save(w);
    }

    public List<Wishlist> findWIshlistItem(Integer contentid) {
       return wishRepository.findBycontentid(contentid);
    }


    public List<Wishlist> findUserItemList(String userId) {
        return wishRepository.findByUserId(userId);
    }
}
