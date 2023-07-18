package com.example.Spring;

import java.util.List;
import java.util.Map;

public interface ShopService {
    List<Item> add(List<Integer> id);
    public Map<Integer, List<Item>> get();
}
