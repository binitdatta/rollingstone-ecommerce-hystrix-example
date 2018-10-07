package com.rollingstone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rollingstone.domain.Person;

@Service
public class PersonService {

	List<Person> persons = new ArrayList<>();
	
	{
		Person personOne = new Person(1, "Steven", "Smith");
		Person personTwo = new Person(1, "Kelly", "Blackburn");
		Person personThree = new Person(1, "Jessica", "Bentley");
		
		persons.add(personOne);
		persons.add(personTwo);
		persons.add(personThree);

		
	}
	
	public List<Person> getAllPersons(){
		return persons;
	}
	
	public Person getPerson(long id) {
		
		Person returnedPerson = null;
		for (Person person : persons) {
			if (person.getId() == id) {
				returnedPerson = person;
			}
		}
		
		return returnedPerson;
	}
}
