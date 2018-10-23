package com.heptalist.demo.service;

import com.heptalist.demo.model.MusicInstrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "instruments")
public class InstrumentService {

	private static final Logger log = LoggerFactory.getLogger(InstrumentService.class);

	@Cacheable(condition = "#name.equals('piano')")
	public MusicInstrument loadByName(String name) {
		log.info("=====================> EXPENSIVE LOAD for instrument with name: {}", name);
		MusicInstrument instrument = new MusicInstrument();
		instrument.setName(name);
		instrument.setPrice(name.length() * 10);
		return instrument;
	}
}
