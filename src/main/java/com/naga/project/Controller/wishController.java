package com.naga.project.Controller;
import com.naga.project.DAO.Wishlist;
import com.naga.project.Repository.wishRepository;
import com.naga.project.Service.wishService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class wishController {

    private final wishService wishService;

    @GetMapping("/api/sbb")
    public List<Wishlist> index()
    {
    return wishService.findWishlist();
    }

   @GetMapping("/api/create")
    public String create(@RequestParam String title,@RequestParam String addr1, @RequestParam String img, @RequestParam String tel, @RequestParam Integer contentid, @RequestParam Integer contenttypeid){
        wishService.create(title,addr1,img,tel,contentid,contenttypeid);
        return "생성";
    }

}
