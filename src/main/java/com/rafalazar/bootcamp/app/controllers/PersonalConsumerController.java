package com.rafalazar.bootcamp.app.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafalazar.bootcamp.app.documents.PersonalConsumer;
import com.rafalazar.bootcamp.app.dto.PersonalDto;
import com.rafalazar.bootcamp.app.service.PersonalConsumerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personalConsumer")
public class PersonalConsumerController {
	private static final Logger log = LoggerFactory.getLogger(PersonalConsumerController.class);
	
	@Autowired
	private PersonalConsumerService service;
	
	//Listamos todos los clientes
	@GetMapping("/findAll")
	Flux<PersonalConsumer> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/findById/{id}")
	Mono<PersonalConsumer>findById(@PathVariable("id") String id){
		return service.findById(id);
	}
	
	@PostMapping("/create")
	public Mono<ResponseEntity<PersonalConsumer>> create(@RequestBody PersonalConsumer cpersonal){
		return service.save(cpersonal).map(p -> ResponseEntity
				.created(URI.create("/personalConsumer/".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(p)
				);
	}
	
	@DeleteMapping("/deleteById/{id}")
	Mono<PersonalConsumer> deleteById(@PathVariable String id){
		return service.delete(id);
	}
	
	@PutMapping("/update/{id}")
	Mono<PersonalConsumer> update(@PathVariable String id, @RequestBody PersonalConsumer pconsumer){
		return service.update(pconsumer);
	}
	
	@GetMapping("/findById2/{id}")
		Mono<PersonalConsumer>findById2(@PathVariable("id") String id){
			
			return service.findById2(id).flatMap(p -> {
				return service.save(new PersonalConsumer("Activo",p));
			});
	}
	
	

}
