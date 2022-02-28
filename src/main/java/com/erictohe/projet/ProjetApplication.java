package com.erictohe.projet;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.erictohe.projet.dao.EntrepriseRepository;
import com.erictohe.projet.dao.TaxeRepository;
import com.erictohe.projet.entities.Entreprise;
import com.erictohe.projet.entities.IR;
import com.erictohe.projet.entities.TVA;

@SpringBootApplication
public class ProjetApplication implements CommandLineRunner{
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private TaxeRepository taxerepository;
	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Entreprise e1=entrepriseRepository.save(new Entreprise("R1", "r1@gmail.com", "SARL"));
		Entreprise e2=entrepriseRepository.save(new Entreprise("R2", "r2@gmail.com", "SARL"));
		
		taxerepository.save(new TVA("TVA Habitation", new Date (), 900, e1));
		taxerepository.save(new TVA("TVA Voiture", new Date (), 900, e1));
		taxerepository.save(new IR("IR 2016", new Date (), 4500, e1));
		taxerepository.save(new TVA("TVA Habitation", new Date (), 400, e2));
		
	}

}
