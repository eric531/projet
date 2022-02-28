package com.erictohe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erictohe.projet.entities.Entreprise;

public  interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {
	@Query("select e from Entreprise e where e.nom like %:nom%")
	public Page<Entreprise>chercher(@Param("nom")String nom, Pageable pageable);
	
	@Query("select e from Entreprise e where e.code=:code")
	public Entreprise finOnes(@Param("code")Long code);
	
	/*
	 * @Query("delete e from Entreprise e where e.code=:code") public Entreprise
	 * delete(@Param("code")Long code);
	 */
}
