package com.projetODC.Projet;

import com.projetODC.Projet.Model.Pays;
import com.projetODC.Projet.Model.Regions;
import com.projetODC.Projet.Repo.PaysRepository;
import com.projetODC.Projet.Repo.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetApplication {
	/* @Autowired
	private PaysRepository pays;
	@Autowired
	private RegionsRepository regions;
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}


}
