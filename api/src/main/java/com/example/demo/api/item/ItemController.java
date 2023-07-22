package com.example.demo.api.item;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemFindService itemFindService;
    
    @GetMapping("/items")
    @ResponseBody
    @CrossOrigin
    public Object findItems() {
        return itemFindService.findItems();
    }

    @GetMapping("/item")
    @ResponseBody
    @CrossOrigin
    public Object item(ItemRequest itemRequest){
        // 未実装：単項目チェック

        return itemFindService.findItem(itemRequest.getId());
    }
}
