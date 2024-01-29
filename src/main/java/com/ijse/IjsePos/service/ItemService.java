package com.ijse.IjsePos.service;

import com.ijse.IjsePos.dto.ItemDTO;
import com.ijse.IjsePos.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Item> getAllProducts();
    Item createProduct(ItemDTO itemDTO);
    Item updateItem(Long id, Item item);
    Item getProductsBy(Long id);
    List<Item> getProductsByCategory(Long id);
}
