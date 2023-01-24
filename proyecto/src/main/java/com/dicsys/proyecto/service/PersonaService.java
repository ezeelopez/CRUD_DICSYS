package com.dicsys.proyecto.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dicsys.proyecto.entity.Persona;
import com.dicsys.proyecto.repositories.PersonaRepositories;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepositories personaRepositories;
	
	
	@Transactional
	public Persona registrar(Persona persona) throws Exception{
		
		Persona personas = new Persona();
		
		personas.setId(persona.getId());
		personas.setNombre(persona.getNombre());
		personas.setApellido(persona.getApellido());
		personas.setSexo(persona.getSexo());
		personas.setDocuemnto(persona.getDocuemnto());
		personas.setEdad(persona.getEdad());
		
		personaRepositories.save(personas);
		
	
		return persona;
	}
	
	@Transactional
	public Persona modificar(Persona persona) throws Exception {
		
		Optional<Persona> modificar = buscarPersonaPorID(persona.getId());	
		 if(modificar.isPresent()) {
			 Persona personas = modificar.get();
			 
				personas.setNombre(persona.getNombre());
				personas.setApellido(persona.getApellido());
				personas.setSexo(persona.getSexo());
				personas.setDocuemnto(persona.getDocuemnto());
				personas.setEdad(persona.getEdad());
				personaRepositories.save(personas);
			 return persona;
		 } else {
			 throw new Exception("no se ha encontrado la solicitud");
		 }
		 
		 }
		
	@Transactional
	 public void eliminar(Persona persona) throws Exception{
		try {
			personaRepositories.deleteById(persona.getId());
		 
		} catch (Exception e) {
			
		
			throw new Exception();
		}
	}
	 
	
	@Transactional
	public Optional<Persona> buscarPersonaPorID(Integer id){
		Optional<Persona> buscar = personaRepositories.findById(id);
		return buscar;
	}

	
	
}
