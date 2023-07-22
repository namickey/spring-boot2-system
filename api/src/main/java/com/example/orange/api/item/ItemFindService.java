package com.example.orange.api.item;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.orange.api.mapper.ItemMapper;
import com.example.orange.common.entity.Item;

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
