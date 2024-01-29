package com.ijse.IjsePos.controller;

import com.ijse.IjsePos.dto.ItemDTO;
import com.ijse.IjsePos.entity.Item;
import com.ijse.IjsePos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    List<Item> getAllProducts(){
        return itemService.getAllItems();
    }

    @PostMapping("/items")
    Item createProduct(@RequestBody ItemDTO productDTO){
        return itemService.createItem(productDTO);
    }

    @GetMapping("/items/{id}")
    public Item getProductById(@PathVariable Long id){
        return itemService.getItemById(id);
    }

    @PutMapping("/items/{id}")
    public Item updateProduct(@PathVariable Long id , @RequestBody Item product){
        return itemService.updateItem(id,product);
    }

    @GetMapping("/categories/{id}/items")
    public ResponseEntity<List<Item>> getProductsByCategory(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getItemByCategory(id));
    }
}
