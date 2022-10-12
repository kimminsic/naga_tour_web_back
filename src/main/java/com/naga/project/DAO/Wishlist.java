package com.naga.project.DAO;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String addr1;

    private String img;

    private String tel;

    private Integer contentid;

    private Integer contenttypeid;
}
