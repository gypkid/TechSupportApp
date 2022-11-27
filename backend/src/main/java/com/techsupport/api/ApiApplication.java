package com.techsupport.api;

import com.techsupport.api.models.Address;
import com.techsupport.api.models.Person;
import com.techsupport.api.repo.AddressRepo;
import com.techsupport.api.repo.PersonRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(PersonRepo personRepo, AddressRepo addressRepo){

		return args -> {
			List<Person> personsList;


			Address address = new Address("ul. trata", "20", "02-236","Warsaw");

			personsList = new ArrayList<Person>();
			personsList.add(new Person("Yashwant", "Chavan" ));
			personsList.add(new Person("Mahesh", "More" ));
			personsList.add(new Person("Ganesh", "Patil", address ));

			for (Person p : personsList
			) {
 				personRepo.save(p);
			}

			/*User user = new User("admin", "{bcrypt}admin", true);
			Authorities auth = new Authorities(user.getUsername(), "ADMIN");
			userRepo.save(user);
			authRepo.save(auth);*/
		};
	}

}
