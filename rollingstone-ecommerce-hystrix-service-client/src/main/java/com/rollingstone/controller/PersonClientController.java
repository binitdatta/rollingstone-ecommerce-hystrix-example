package com.rollingstone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.Person;
import com.rollingstone.service.PersonClientService;

@RestController
@RequestMapping(value="/api/rollingstone/person/client")
public class PersonClientController {

	private PersonClientService personClientService;

	public PersonClientController(PersonClientService personClientService) {
		this.personClientService = personClientService;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Person getPersons(@PathVariable("id") long id){
		return personClientService.getPerson(id);
	}
}
