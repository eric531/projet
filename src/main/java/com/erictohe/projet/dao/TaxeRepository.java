package com.erictohe.projet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erictohe.projet.entities.Entreprise;
import com.erictohe.projet.entities.Taxe;

public interface TaxeRepository extends JpaRepository<Taxe ,Long> {
	public List<Taxe> findByEntreprise(Entreprise  e);
}
