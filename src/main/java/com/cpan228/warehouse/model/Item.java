package com.cpan228.warehouse.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Brand brandName;
    private int yearItem;
    private double price;

    public enum Brand {

        BALENCIAGA("Balenciaga"), CHANEL("Chanel"), DIOR("Dior"), GUCCI("Gucci"), PRADA("Prada");

        private  String name;
        private Brand(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    public Item(String name, int yearItem, double price, Brand brandName) {
        this.name = name;
        this.yearItem = yearItem;
        this.price = price;
        this.brandName = brandName;
    }
    public Item(Long id, String name, int yearItem, double price, Brand brandName) {
        this.id = id;
        this.name = name;
        this.yearItem = yearItem;
        this.price = price;
        this.brandName = brandName;
    }

    public Item() {

    }
}
