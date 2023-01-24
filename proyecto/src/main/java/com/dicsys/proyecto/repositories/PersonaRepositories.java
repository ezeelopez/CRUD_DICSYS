package com.dicsys.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dicsys.proyecto.entity.Persona;

@Repository
public interface PersonaRepositories extends JpaRepository<Persona, Integer> {

	
	
}
