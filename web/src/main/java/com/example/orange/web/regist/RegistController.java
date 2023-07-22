package com.example.orange.web.regist;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.orange.common.entity.Item;

import lombok.RequiredArgsConstructor;

/*
 * 登録画面コントローラ
 */
@Controller
@RequiredArgsConstructor
public class RegistController {

    /** item登録サービス */
    private final ItemRegistService itemRegistService;

    /*
     * 表示
     */
    @GetMapping("/regist/index")
    public String index(ItemForm itemForm) {
        // 登録画面を表示する
        return "regist/regist";
    }

    /*
     * 確認
     */
    @PostMapping("/regist/confirm")
    public String confirm(ItemForm itemForm) {
        // 確認画面を表示する
        return "regist/confirm";
    }

    /*
     * 登録
     */
    @PostMapping("/regist/regist")
    public String regist(ItemForm itemForm) {

        Item item = new Item();
        BeanUtils.copyProperties(itemForm, item);

        itemRegistService.registItem(item);
        return "redirect:/regist/complete";
    }

    /*
     * 完了
     */
    @GetMapping("/regist/complete")
    public String complete() {
        return "regist/complete";
    }
}
