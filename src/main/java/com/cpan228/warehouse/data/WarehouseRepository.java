package com.cpan228.warehouse.data;

import com.cpan228.warehouse.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByBrandNameAndYearItem(Item.Brand brandName, int yearItem);
    List<Item> findByOrderByBrandNameAsc ();


}
