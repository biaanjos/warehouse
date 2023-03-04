package com.cpan228.warehouse.model.dto;

import com.cpan228.warehouse.model.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemSearchByBrand {
    Item.Brand brandName;
    int yearItem;

}
