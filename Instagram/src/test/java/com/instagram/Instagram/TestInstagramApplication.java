package com.instagram.Instagram;

import org.springframework.boot.SpringApplication;

public class TestInstagramApplication {

	public static void main(String[] args) {
		SpringApplication.from(InstagramApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
