package com.example.Spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@SessionScope
public class ShopServiceImpl implements ShopService {
    List<Item> store = new ArrayList<>(List.of(
            new Item("Йгурт", 60, 2),
            new Item("Банан", 50, 4),
            new Item("Мясо", 70, 3),
            new Item("Помела", 90, 1)
    ));
    List<Item> bay = new ArrayList<>(List.of());
    //сделать отдельный обьект

    @Override
    public List<Item> add(List<Integer> id) {
        for (Integer integer : id) {
            for (Item item : store) {
                if (item.getId() == integer) {
                    bay.add(item);
                }
            }
        }
//        List<Item> b =  store.stream()
//                .filter(i ->(i.getId()==id))
//                .collect(Collectors.toList());
//        bay.add(b);
        return bay;
    }


    @Override
    public Map<Integer, List<Item>> get() {
        return bay.stream()
                .collect(groupingBy(Item::getId));
    }
}

