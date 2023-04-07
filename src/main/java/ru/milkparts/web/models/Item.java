package ru.milkparts.web.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
public class Item {

    @Id
    @Column(name = "ITEM_ID")
    private String itemId;
    @Column(name="ITEM_RU")
    private String itemRu;
    @Column(name="ITEM_DESCRIPTION")
    private String itemDescription;
    @Column(name="ITEM_KEYWORDS")
    private String itemKeywords;
    @Column(name="CAT_CANONICAL")
//    TODO check CascadeType
//    @PrimaryKeyJoinColumn(name="CAT_ID")
//    @OneToOne
    private String catCanonicalId;

//    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
//    private List<Category> categories;
    @Column(name="ITEM_FIRST_PAGE")
    private Boolean itemFirstPage;
}
