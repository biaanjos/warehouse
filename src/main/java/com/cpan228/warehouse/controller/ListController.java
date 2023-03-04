package com.cpan228.warehouse.controller;

import com.cpan228.warehouse.data.WarehouseRepository;
import com.cpan228.warehouse.model.dto.ItemSearchByBrand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @ModelAttribute
    public void itemSearchByBrand(Model model) {
        model.addAttribute("itemByBrand", new ItemSearchByBrand());
    }
    @PostMapping("/all")
    public String searchItemByBrand(@ModelAttribute ItemSearchByBrand itemByBrand,
                                    Model model) {
        model.addAttribute("items", repository.findAllByBrandNameAndYearItem(itemByBrand.getBrandName(),2022));
        return "itemlist";
    }
}
