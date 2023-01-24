package com.dicsys.proyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dicsys.proyecto.entity.Persona;
import com.dicsys.proyecto.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private PersonaService servicioPersona;
	
	@PostMapping("/registrar")
	public ResponseEntity<Persona> registrar(@RequestBody Persona persona) throws Exception{
		
		try {

			return new ResponseEntity<Persona>(servicioPersona.registrar(persona), HttpStatus.CREATED);

		}catch(Exception e) {
			
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
	}

	@PutMapping("/modificar")
	public ResponseEntity<Persona> modificar(@RequestBody Persona persona) throws Exception {
		
		try {
			
			servicioPersona.buscarPersonaPorID(persona.getId());
			servicioPersona.modificar(persona);
			return new ResponseEntity<Persona>(servicioPersona.modificar(persona), HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
		
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/eliminar")
    public ResponseEntity<Persona> eliminar( @RequestBody Persona persona)throws Exception{
	 
	 try {
		 
		servicioPersona.eliminar(persona);
		
		return new ResponseEntity<Persona>(HttpStatus.OK);
		
	} catch (Exception e) {
		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		
	}

 }
	
	
}
