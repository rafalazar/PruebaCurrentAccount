package com.rafalazar.bootcamp.app;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafalazar.bootcamp.app.documents.PersonalConsumer;
import com.rafalazar.bootcamp.app.dto.PersonalDto;
import com.rafalazar.bootcamp.app.service.PersonalConsumerService;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class PruebaConsumoCurrentAccountApplication implements CommandLineRunner {
	
	@Autowired
	private PersonalConsumerService service;
	
//	@Autowired
//	private PersonalDto dto;
	
	private static final Logger log = LoggerFactory.getLogger(PruebaConsumoCurrentAccountApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PruebaConsumoCurrentAccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//				Flux.just(
//						new PersonalConsumer("Inactivo", "fdffdffdsd")
//				)
//				.flatMap(p -> {
//					return service.save(p);
//				})
//		.subscribe(p -> log.info("Insertando: " + p.getStatus() + " " + p.getCodCliP()));
		
	}

}
