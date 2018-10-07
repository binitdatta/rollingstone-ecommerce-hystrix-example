package com.rollingstone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.Person;
import com.rollingstone.service.PersonService;

@RestController
@RequestMapping(value="/api/rollingstone/person")
public class PersonController {

	private PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping()
	@ResponseBody
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Person getPersons(@PathVariable("id") long id){
		return personService.getPerson(id);
	}
}
