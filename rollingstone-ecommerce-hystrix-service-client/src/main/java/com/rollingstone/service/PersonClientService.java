package com.rollingstone.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rollingstone.domain.Person;

@Service
public class PersonClientService {

	PersonServiceFeignClient personFeignClient;
	
	public PersonClientService(PersonServiceFeignClient personFeignClient) {
		this.personFeignClient = personFeignClient;
	}
	
	@HystrixCommand(fallbackMethod = "getDefaultPerson",
		    commandProperties = {
		        @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"),
		        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
		        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="60")
		    }
		)
	//@HystrixCommand(fallbackMethod = "getDefaultPerson")
			public Person getPerson(long id) {
		return personFeignClient.getPersons(id);
	}
	
	public Person getDefaultPerson(long id) {
		return new Person(1,"Default","Hystrix Person");
	}
}
