package com.example.orange.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.orange.common.entity.Item;

/**
 * Itemマッパー
 */
@Mapper
public interface ItemMapper {

    /**
     * itemを全件取得する
     * @return itemリスト
     */
    @Select("select * from item")
    List<Item> select();

    /**
     * itemを1件取得する
     * @param id ID
     * @return item
     */
    @Select("select * from item where id = #{id}")
    Item find(Integer id);
}
