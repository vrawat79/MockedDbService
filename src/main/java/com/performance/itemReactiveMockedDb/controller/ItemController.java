package com.performance.itemReactiveMockedDb.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.performance.itemReactiveMockedDb.domain.Item;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class ItemController {

//	@Autowired
//	private ItemService itemService;

	List<Item> itemList = new ArrayList<Item>();

	@PostConstruct
	private void postConstruct() {

		for (int i = 0; i < 5000; i++) {

			Item item = new Item();
			item.setBrand("IBM");
			item.setCategory("Laptop");
			item.setDescription("HP Spectre");
			this.itemList.add(item);

		}
	}

	@GetMapping(path = "/items/stream/{category}", produces="application/stream+json")
	public Flux<Item> getItemsbyCategoryStream(@PathVariable String category) {
		Flux<Item> itemFlux = null;
		if (category.equalsIgnoreCase("Laptop")) {
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

			itemFlux = Flux.just(item1, item2, item3);

		} else {
			itemFlux = Flux.fromIterable(this.itemList);

		}
		return itemFlux.delaySequence(Duration.ofMillis(200));
	}
	
	@GetMapping(path = "/items/{category}")
	public Flux<Item> getItemsbyCategory(@PathVariable String category) {
		Flux<Item> itemFlux = null;
		if (category.equalsIgnoreCase("Laptop")) {
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

			itemFlux = Flux.just(item1, item2, item3);

		} else {
			itemFlux = Flux.fromIterable(this.itemList);

		}
		return itemFlux.delaySequence(Duration.ofMillis(200));
	}

//	@PostMapping(path = "/items")
//	public Flux<Item> createBulkItems(@RequestBody Flux<Item> itemFlux) {
//
//		return itemService.createAllItems(itemFlux);
//	}

}
