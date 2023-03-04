package com.cpan228.warehouse;

import com.cpan228.warehouse.data.WarehouseRepository;
import com.cpan228.warehouse.model.Item;
import com.cpan228.warehouse.model.Item.Brand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(WarehouseRepository repository) {
		return args -> {
			repository.save(new Item("Black bag",2022, 2680, Brand.CHANEL));
			repository.save(new Item("Red Dress",2023, 2580, Brand.GUCCI));
			repository.save(new Item("Black Skirt",2022, 3500, Brand.DIOR));
			repository.save(new Item("White Shoes",2022, 2800, Brand.DIOR));
			repository.save(new Item("Blue T-shirt",2023, 2000, Brand.BALENCIAGA));
			repository.save(new Item("Yellow Jacket",2022, 3580, Brand.DIOR));
			repository.save(new Item("Blue Shoes",2022, 2887, Brand.PRADA));

		};
	}

}
