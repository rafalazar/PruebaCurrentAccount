package com.rafalazar.bootcamp.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rafalazar.bootcamp.app.documents.PersonalConsumer;

public interface PersonalClientRepository extends ReactiveMongoRepository<PersonalConsumer, String>{

}
