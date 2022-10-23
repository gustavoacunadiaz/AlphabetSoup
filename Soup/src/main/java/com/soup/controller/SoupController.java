package com.soup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soup.model.Palabra;
import com.soup.model.Soup;
import com.soup.service.SoupService;

@RestController
@RequestMapping("/alphabetSoup")
public class SoupController {

	@Autowired
	private SoupService soupService;
	
	public SoupController(SoupService soupService) {
		this.soupService = soupService;
	}
	
//	@PostMapping("/")
//	public Soup createSoup(@RequestBody Soup soup) {
//		 return soupService.save(soup);
//	}
	
	@GetMapping(value="/list/{uuid}", produces = "application/json")
	public String listSoup(@PathVariable("uuid") long uuid) {
		return soupService.findByUuid(uuid);
	}
	
//	@GetMapping("/view/:uuid")
//	public List<Palabra> listPalabras() {
//		return soupService.findAll();
//	}
	
//	@PutMapping("{uuid}")
//	public String validaPalabra(@PathVariable long uuid) {
//		String output = null;
//		
//		String palabra = soupService.findByUuid(uuid);
//		
//		soupService.validaPalabra();
//				
//		return output; 
//	}
	
}












