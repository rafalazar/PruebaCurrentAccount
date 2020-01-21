package com.rafalazar.bootcamp.app.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rafalazar.bootcamp.app.dto.PersonalDto;

import lombok.Data;

@Data
@Document(collection="consulting_clients")
public class PersonalConsumer {
	
	@Id
	private String id;
	private String status;
	private PersonalDto personalDto;
//	private String idClient;
	
	public PersonalConsumer() {
		
	}

	public PersonalConsumer(String status, PersonalDto personalDto) {
		super();
		this.status = status;
		this.personalDto = personalDto;
	}
	
//	public PersonalConsumer(String status, String idClient) {
//		this.status = status;
//		this.idClient = idClient;
//	}
	
	

}
