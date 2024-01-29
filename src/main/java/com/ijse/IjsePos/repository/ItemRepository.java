package com.ijse.IjsePos.repository;

import com.ijse.IjsePos.entity.Category;
import com.ijse.IjsePos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query("select i from Item i WHERE i.category=:category")
    List<Item> findItemsByCategory(@Param("category")Category category);
}
