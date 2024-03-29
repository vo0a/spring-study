package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setName("노트북");
        item.setPrice(100000);
        item.setContent("삼성 노트북");

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }

    @Test
    @Transactional
    public void read(){
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        // Optional 이므로 assertIsNotNull 이 아니라 true or false
        Assert.assertTrue(item.isPresent());

        item.ifPresent(i -> {
            System.out.println(i);
        });
    }
}
