package com.cpan228.warehouse.controller;

import com.cpan228.warehouse.data.WarehouseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/all")
public class ListController {

    private WarehouseRepository repository;
    public ListController(WarehouseRepository repository){
        this.repository = repository;
    }
    @GetMapping
    public String showItems(Model model) {
        return "list";
    }
    @ModelAttribute
    public void findAllItems(Model model) {
        model.addAttribute("items", repository.findAll());
    }

}
