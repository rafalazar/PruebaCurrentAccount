package com.rafalazar.bootcamp.app.service;

import com.rafalazar.bootcamp.app.documents.PersonalConsumer;
import com.rafalazar.bootcamp.app.dto.PersonalDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonalConsumerService {
	
	public Flux<PersonalConsumer> findAll();
	public Mono<PersonalConsumer> findById(String id);
	public Mono<PersonalConsumer> update(PersonalConsumer consumerp);
	public Mono<PersonalConsumer> delete(String id);
	public Mono<PersonalConsumer> save(PersonalConsumer consumerp);
	
	Mono<PersonalDto> findById2(String id);
	
	

}
