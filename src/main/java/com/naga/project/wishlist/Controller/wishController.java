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
    public List<Wishlist> indexItem(@RequestParam Integer contentid){
        return wishService.findWIshlistItem(contentid);
    }

   @GetMapping("/api/create")
    public String create(@RequestParam String title,@RequestParam String addr1, @RequestParam String img, @RequestParam String tel, @RequestParam Integer contentid, @RequestParam Integer contenttypeid){
        List<Wishlist> w = wishRepository.findBycontentid(contentid);
        if(w.isEmpty()) {
            wishService.create(title, addr1, img, tel, contentid, contenttypeid);
            return "생성";
        }
        return "생성불가";
    }

    @GetMapping("/api/delete")
    public String deleteItem(@RequestParam Integer contentid){
        List<Wishlist> w = wishRepository.findBycontentid(contentid);
        if(w.isEmpty()){
            return "존재하지 않습니다";
        }

        wishRepository.deleteBycontentid(contentid);
        return "삭제하였습니다";
    }

}
