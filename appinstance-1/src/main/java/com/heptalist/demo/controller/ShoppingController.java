package com.heptalist.demo.controller;

import com.heptalist.demo.model.MusicInstrument;
import com.heptalist.demo.service.InstrumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController("/shop")
public class ShoppingController {

	private static final Logger log = LoggerFactory.getLogger(ShoppingController.class);

	@Autowired
	private InstrumentService instrumentService;

	@PostMapping("/instrument")
	public ResponseEntity addInstrument(@RequestBody MusicInstrument musicInstrument) throws URISyntaxException {
		return ResponseEntity.created(new URI("/shop/instrument/")).build();
	}

	@GetMapping("/instrument/{name}")
	public ResponseEntity<MusicInstrument> showInstrument(@PathVariable("name") String name) {
		log.info("Getting instrument for name: {}", name);
		MusicInstrument instrument = instrumentService.loadByName(name);
		log.info("Giving back result: name -> {}, price -> {}", instrument.getName(), instrument.getPrice());
		return ResponseEntity.ok(instrument);
	}
}
