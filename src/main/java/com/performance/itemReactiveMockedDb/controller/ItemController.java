package com.performance.itemReactiveMockedDb.controller;

import java.time.Duration;

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

	@GetMapping(path = "/items/{category}")
	public Flux<Item> getItemsbyCategory(@PathVariable String category) {

//		Runnable t = () -> {
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		};
//
//		t.run();

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

		Flux<Item> itemFlux = Flux.just(item1, item2, item3);
		return itemFlux.delaySequence(Duration.ofMillis(200));

	}

//	@PostMapping(path = "/items")
//	public Flux<Item> createBulkItems(@RequestBody Flux<Item> itemFlux) {
//
//		return itemService.createAllItems(itemFlux);
//	}

}
