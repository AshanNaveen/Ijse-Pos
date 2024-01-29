package com.ijse.IjsePos.service;

import com.ijse.IjsePos.dto.ItemDTO;
import com.ijse.IjsePos.entity.Category;
import com.ijse.IjsePos.entity.Item;
import com.ijse.IjsePos.repository.CategoryRepository;
import com.ijse.IjsePos.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Item> getAllProducts() {
        return itemRepository.findAll();
    }

    @Override
    public Item createProduct(ItemDTO itemDTO) {
        Category category = categoryRepository.findById(itemDTO.getCategoryId()).orElse(null);

        if (category != null){
            Item item = new Item();
            item.setName(itemDTO.getName());
            item.setPrice(itemDTO.getPrice());
            item.setQty(itemDTO.getQty());
            item.setCategory(category);
            return itemRepository.save(item);
        }
        else return null;
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem != null){
            existingItem.setName(item.getName());
            existingItem.setCategory(item.getCategory());
            existingItem.setPrice(item.getPrice());
            existingItem.setQty(item.getQty());
            return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public Item getProductsBy(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> getProductsByCategory(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);

        if (category != null){
            return itemRepository.findItemsByCategory(category);
        }
        return null;
    }
}
