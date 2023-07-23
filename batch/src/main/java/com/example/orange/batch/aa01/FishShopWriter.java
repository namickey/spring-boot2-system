package com.example.orange.batch.aa01;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.example.orange.common.entity.Item;

@Component
public class FishShopWriter implements ItemWriter<Item> {
    private int i;

    @Override
    public void write(List<? extends Item> list) throws Exception {
        for (Item item: list) {
            i++;
            if (i % 3 == 1) {
                System.out.println(item.getId() + ", " + item.getItemName());
            }
        }
    }
}
