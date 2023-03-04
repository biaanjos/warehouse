package com.cpan228.warehouse.controller;

import com.cpan228.warehouse.data.WarehouseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListController {

    private WarehouseRepository repository;
    public ListController(WarehouseRepository repository){
        this.repository = repository;
    }
    @GetMapping("/all")
    public String showItems(Model model) {
        return "itemlist";
    }
    @ModelAttribute
    public void findAllItems(Model model) {
        model.addAttribute("items", repository.findAll());
    }
    @RequestMapping(value = "/allSorted")
    public String orderedList(Model model){
        model.addAttribute("items", repository.findByOrderByBrandNameAsc());
        return "itemlist";
    }
}
