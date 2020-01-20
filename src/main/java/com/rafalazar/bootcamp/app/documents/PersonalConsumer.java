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
	
	public PersonalConsumer() {
		
	}

	public PersonalConsumer(String status, PersonalDto personalDto) {
		super();
		this.status = status;
		this.personalDto = personalDto;
	}
	
	

}
