package ru.milkparts.web.repositories;

import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.milkparts.web.models.Item;

import java.util.List;


@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private TestEntityManager em;

    private Item item = new Item("test","деталь","полная деталь","деталюшка","дренаж",true);

    @Test
    void findItemByItemId() {


    }

    @Test
    void addItemTestShouldBeOk(){
        TypedQuery<Item> query = em.getEntityManager()
                .createQuery("SELECT i FROM Item as i", Item.class);
        List<Item> list = query.getResultList();
        Assertions.assertEquals(2, list.size());
    }
}