package com.example.orange.batch.aa01;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.example.orange.common.entity.Item;

@Component
public class FishShopProcessor implements ItemProcessor<CsvItem, Item> {
    @Override
    public Item process(@NonNull CsvItem csvItem) throws Exception {
        Item newItem = new Item();
        newItem.setId(csvItem.getId());
        newItem.setItemName(csvItem.getItemName());
        newItem.setPrice(csvItem.getPrice());
        return newItem;
    }
}
