package ru.milkparts.web.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
public class Category {

    @Id
    @Column(name = "CAT_ID")
    private String catId;
    @Column(name = "CAT_RU")
    private String catRu;
    @Column(name = "CAT_DESCRIPTION")
    private String catDescription;
    @Column(name = "CAT_KEYWORDS")
    private String catKeywords;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Item> items;
}
