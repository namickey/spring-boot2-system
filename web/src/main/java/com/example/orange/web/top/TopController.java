package com.example.orange.web.top;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.orange.common.entity.Item;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TopController {

    private final ItemFindService itemFindService;

    @GetMapping("/")
    public String top(Model model) {
        List<Item> itemList = itemFindService.findItems();
        model.addAttribute("itemList", itemList);
        return "top/index";
    }
}
