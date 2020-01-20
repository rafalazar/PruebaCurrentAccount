package com.rafalazar.bootcamp.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafalazar.bootcamp.app.client.PersonalClient;
import com.rafalazar.bootcamp.app.documents.PersonalConsumer;
import com.rafalazar.bootcamp.app.dto.PersonalDto;
import com.rafalazar.bootcamp.app.repository.PersonalClientRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonalConsumerServiceImpl implements PersonalConsumerService{
	
	private static final Logger log = LoggerFactory.getLogger(PersonalClient.class);

	
	@Autowired
	private PersonalClient pclient;
	
	@Autowired
	private PersonalClientRepository repo;
	
	@Override
	public Flux<PersonalConsumer> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<PersonalConsumer> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<PersonalConsumer> update(PersonalConsumer consumerp) {
		return repo.findById(consumerp.getId())
				.map(p -> consumerp)
				.flatMap(repo::save);
	}

	@Override
	public Mono<PersonalConsumer> delete(String id) {
		return repo.findById(id)
				.flatMap(p -> {
					p.getId();
					p.setStatus("Inactive - Deleted");
					//p.getCodCliP();
					return update(p);
				});
	}

	@Override
	public Mono<PersonalDto> findById2(String id) {
		return pclient.findById(id);
	}

	@Override
	public Mono<PersonalConsumer> save(PersonalConsumer consumerp) {
		return repo.save(consumerp);
	}



}
