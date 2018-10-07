package com.rollingstone.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rollingstone.domain.Person;

@FeignClient(name = "rollingstone-ecommerce-hystrix-service-api")
public interface PersonServiceFeignClient {

	@GetMapping("/api/rollingstone/person/{id}")
	public Person getPersons(@PathVariable("id") long id);
}
