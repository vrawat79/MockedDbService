package com.performance.itemReactiveMockedDb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.performance.itemReactiveMockedDb.domain.Item;

import reactor.core.publisher.Flux;

@RestController
public class ItemController {

//	@Autowired
//	private ItemService itemService;

	@GetMapping(path = "/items/{category}")
	public Flux<Item> getItemsbyCategory(@PathVariable String category) {

		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Item item1 = new Item();
		item1.setBrand("IBM");
		item1.setCategory("Laptop");
		item1.setDescription("HP Spectre");	

		Item item2 = new Item();
		item2.setBrand("Dell");
		item2.setCategory("Laptop");
		item2.setDescription("XPS");

		Item item3 = new Item();
		item3.setBrand("IBM");
		item3.setCategory("Laptop");
		item3.setDescription("HP Spectre");		

		return Flux.just(item1, item2, item3);

	}

//	@PostMapping(path = "/items")
//	public Flux<Item> createBulkItems(@RequestBody Flux<Item> itemFlux) {
//
//		return itemService.createAllItems(itemFlux);
//	}

}
