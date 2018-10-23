package com.heptalist.demo.feign.controller;

import com.heptalist.demo.feign.interfaces.ShoppingClient;
import com.heptalist.demo.model.MusicInstrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {

	private static final Logger log = LoggerFactory.getLogger(ShoppingController.class);

	@Autowired
	private ShoppingClient shoppingClient;

	@GetMapping("/shop/instrument/{name}")
	public ResponseEntity<MusicInstrument> show(@PathVariable("name")String name){
		return shoppingClient.showInstrument(name);
	}
}
