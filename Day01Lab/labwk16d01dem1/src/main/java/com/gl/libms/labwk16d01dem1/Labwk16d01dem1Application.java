package com.gl.libms.labwk16d01dem1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.gl.libms.labwk16d01dem1.controller","com.gl.libms.labwk16d01dem1.model","com.gl.libms.labwk16d01dem1.service","com.gl.libms.labwk16d01dem1.model.dao"})
public class Labwk16d01dem1Application {

	public static void main(String[] args) {
		SpringApplication.run(Labwk16d01dem1Application.class, args);
		System.out.println("Welcome to H2 based SpringBoot Application");
	}

}
