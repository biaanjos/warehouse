package com.cpan228.warehouse.controller;

import com.cpan228.warehouse.data.WarehouseRepository;
import com.cpan228.warehouse.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

        private WarehouseRepository repository;
        public SearchController(WarehouseRepository repository){
            this.repository = repository;
        }
        @GetMapping
        public String showItems(Model model) {
            return "itemlist";
        }
        @ModelAttribute
        public void findItems( Model model) {
            model.addAttribute("items", repository.findAllByBrandNameAndYearItem(Item.Brand.DIOR, 2022));
        }
    }

