package com.home;

import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.github.javafaker.Faker;
import com.home.entity.Employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class RestfulApiApplication implements CommandLineRunner{
	@Autowired
	EntityManager entityManager;
	public static void main(String[] args) {
		SpringApplication.run(RestfulApiApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Faker faker = new Faker();
		for (int i = 0; i < 5; i++) {
			var employer = Employer.builder()
					.name(faker.name().fullName())
					.password(faker.name().name())
					.email(faker.internet().emailAddress())
					.address(faker.address().streetAddress()).build();
			entityManager.persist(employer);
		}
		entityManager.flush();
	}

}
