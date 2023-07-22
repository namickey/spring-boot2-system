package com.example.orange.web.regist;

import org.springframework.stereotype.Service;

import com.example.orange.common.entity.Item;
import com.example.orange.web.mapper.ItemMapper;

import lombok.RequiredArgsConstructor;

/**
 * item登録サービス
 */
@Service
@RequiredArgsConstructor
public class ItemRegistService {
    
    /** itemマッパー */
    private final ItemMapper itemMapper;

    /**
     * itemを登録する
     * @param item Item
     */
    public void registItem(Item item) {
        // DBへ登録する
        itemMapper.regist(item);
    }
}
