package com.example.demo.api.item;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemMapper;

import lombok.RequiredArgsConstructor;

/**
 * item検索サービス
 */
@Service
@RequiredArgsConstructor
public class ItemFindService {
    
    /** itemマッパー */
    private final ItemMapper itemMapper;

    /**
     * itemを全件取得する
     * @return itemリスト
     */
    public List<Item> findItems() {
        // 全件取得する
        return itemMapper.select();
    }

    /**
     * itemを1件取得する
     * @param id ID
     * @return Item
     */
    public Item findItem(Integer id) {
        return itemMapper.find(id);
    }
}
