package com.naga.project.wishlist.Controller;
import com.naga.project.wishlist.DAO.Wishlist;
import com.naga.project.wishlist.Repository.wishRepository;
import com.naga.project.wishlist.Service.wishService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class wishController {

    private final wishService wishService;
    private final wishRepository wishRepository;
    @GetMapping("/api/items")
    public List<Wishlist> index()
    {
    return wishService.findWishlist();
    }

    @GetMapping("/api/item")
    public List<Wishlist> indexItem(@RequestParam Integer contentid, @RequestParam String userId){
        return wishService.findWIshlistItem(contentid,userId);
    }

    @GetMapping("/api/user/item")
    public List<Wishlist> indexUserItem(@RequestParam String userId){
        return wishService.findUserItemList(userId);
    }

   @GetMapping("/api/create")
    public String create(@RequestParam String title,@RequestParam String addr1, @RequestParam String img, @RequestParam String tel, @RequestParam Integer contentid, @RequestParam Integer contenttypeid, @RequestParam String userId){
        List<Wishlist> w = wishRepository.findBycontentidAndUserId(contentid,userId);
        if(w.isEmpty()) {
            wishService.create(title, addr1, img, tel, contentid, contenttypeid,userId);
            return "생성";
        }
        return "생성불가";
    }

    @GetMapping("/api/delete")
    public String deleteItem(@RequestParam Integer contentid, @RequestParam String userId){
        List<Wishlist> w = wishRepository.findBycontentidAndUserId(contentid,userId);
        if(w.isEmpty()){
            return "존재하지 않습니다";
        }

        wishRepository.deleteBycontentid(contentid);
        return "삭제하였습니다";
    }

}
