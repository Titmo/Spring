package com.example.Spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class ShopController implements ShopService {
    private final ShopServiceImpl shopService;

    public ShopController(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }
    @GetMapping("/add")
    @Override
    public List<Item> add(@RequestParam("itemId") List <Integer> id) {
        return shopService.add(id);
    }
    @GetMapping("/get")
    @Override
    public Map<Integer, List<Item>> get() {
        return shopService.get();
    }
}
