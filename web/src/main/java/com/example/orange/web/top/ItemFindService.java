package com.example.orange.web.top;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.orange.common.entity.Item;
import com.example.orange.web.mapper.ItemMapper;

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
}
