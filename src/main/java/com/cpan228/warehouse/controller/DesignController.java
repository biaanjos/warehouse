package com.cpan228.warehouse.controller;

import com.cpan228.warehouse.data.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cpan228.warehouse.model.Item;
import com.cpan228.warehouse.model.Item.Brand;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.EnumSet;

@Controller
@RequestMapping("/design")
public class DesignController {

    @Autowired
    private WarehouseRepository repository;

    @GetMapping
    public String getForm() {
        return "design";
    }
    @ModelAttribute
    public void brands(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
    }
    @ModelAttribute
    public Item item() {
        return new Item();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
    public String submitForm(Item item)  {
        if (item.getYearItem() < 2021 || item.getPrice() < 1000 || item.getBrandName() == null) {
            return "error";
        }
        repository.save(item);

        return "redirect:/all";
    }

}
