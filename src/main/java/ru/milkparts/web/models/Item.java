package ru.milkparts.web.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
//    private Long id;
//    @Column(name="ITEM_NUMBER")
    private String itemId;
    @Column(name="ITEM_RU")
    private String itemRu;
    @Column(name="ITEM_DESCRIPTION")
    private String itemDescription;
    @Column(name="ITEM_KEYWORDS")
    private String itemKeywords;
    @Column(name="CAT_ID")
    private String catId;
    @Column(name="ITEM_FIRST_PAGE")
    private Boolean itemFirstPage;
}
