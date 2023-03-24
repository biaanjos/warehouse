package com.cpan228.warehouse.controller;

import com.cpan228.warehouse.data.WarehouseRepository;
import com.cpan228.warehouse.model.Item;
import com.cpan228.warehouse.model.User;
import com.cpan228.warehouse.model.dto.ItemSearchByBrand;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/management")
public class ManagementController {

    private WarehouseRepository repository;
    public ManagementController(WarehouseRepository repository){
        this.repository = repository;
    }
    @ModelAttribute
    public void findAllItems(Model model) {
        model.addAttribute("items", repository.findAll());
    }
    @ModelAttribute
    public void itemSearchByBrand(Model model) {
        model.addAttribute("itemByBrand", new ItemSearchByBrand());
    }
    @GetMapping
    public String showItems(Model model) {
        return "management";
    }
    @RequestMapping(value = "/allSorted")
    public String orderedList(Model model){
        model.addAttribute("items", repository.findByOrderByBrandNameAsc());
        return "management";
    }
    @PostMapping
    public String searchItemByBrand(@ModelAttribute ItemSearchByBrand itemByBrand,
                                    Model model) {
        model.addAttribute("items", repository.findAllByBrandName(itemByBrand.getBrandName()));
        return "management";
    }
    @PostMapping("/deleteAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String processClothesDeletion(@AuthenticationPrincipal User user) {
        repository.deleteAll();
        return "redirect:/management";
    }

    @PostMapping("/delete/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String processItemDeletion(@AuthenticationPrincipal User user,@RequestParam(value = "id") Long id) {
        repository.deleteById(id);
        return "redirect:/management";
    }
}
