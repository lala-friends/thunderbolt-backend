package com.lala.bolt.thunderboltbackend;

import com.lala.bolt.thunderboltbackend.domain.BoltGroup;
import com.lala.bolt.thunderboltbackend.repository.BoltGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThunderboltBackendApplication implements CommandLineRunner {

	@Autowired
	private BoltGroupRepository boltGroupRepository;

	public static void main(String[] args) {
		SpringApplication.run(ThunderboltBackendApplication.class, args);
	}

	@Override
	public void run(String args[]) {
		System.out.println("##################");

		BoltGroup boltGroup = BoltGroup.builder()

				.name("preban")
				.description("sss")
				.build();
		boltGroupRepository.save(boltGroup).subscribe();

		boltGroupRepository.findAll().log().map(BoltGroup::getDescription)
				.subscribe(System.out::println);

		boltGroupRepository.findByName("preban").log().map(BoltGroup::getDescription).subscribe(System.out::println);

	}
}
