package com.heptalist.demo.feign.interfaces;

import com.heptalist.demo.model.MusicInstrument;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("hello-service")
public interface ShoppingClient {

	@GetMapping("/instrument/{name}")
	ResponseEntity<MusicInstrument> showInstrument(@PathVariable("name") String name);
}
