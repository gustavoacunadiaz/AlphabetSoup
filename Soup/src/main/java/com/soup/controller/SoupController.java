package com.soup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.soup.model.Palabra;
import com.soup.model.Soup;
import com.soup.repository.SoupRepository;
import com.soup.service.SoupService;

@RestController
@RequestMapping("/alphabetSoup")
public class SoupController {
	@Autowired
	private SoupService soupService;
	
	@Autowired
	private SoupRepository soupRepository;
	
	public SoupController(SoupService soupService) {
		this.soupService = soupService;
	}
	
	@PostMapping(value="/", produces = "application/json")
	@ResponseBody
	public String createSoup(@RequestBody Soup soup) {		
		
		Soup s = new Soup();
		s.setBtt(soup.isBtt());
		s.setCadena("holadff\naaojoa");
		s.setD(soup.isD());
		s.setEstado(false);
		s.setH(soup.getH());
		s.setLtr(soup.isLtr());
		s.setRtl(soup.isRtl());
		s.setTtb(soup.isTtb());
		s.setUuidString(soup.getUuidString());
		s.setW(soup.getW());
		soupService.saveSoup(s);	
		
		Palabra p1 = new Palabra ("hola",0,0,3,0,s.getUuidString(),false);
		Palabra p2 = new Palabra ("planta",0,1,5,1,s.getUuidString(),false);
		Palabra p3 = new Palabra ("edificio",0,2,7,2,s.getUuidString(),false);
		Palabra p4 = new Palabra ("refrigerador",0,3,11,3,s.getUuidString(),false);
		
		soupService.savePalabra(p1);
		soupService.savePalabra(p2);
		soupService.savePalabra(p3);
		soupService.savePalabra(p4);
				
		return s.getUuidString(); 
	}
	
	@GetMapping(value="/list/{uuid}", produces = "application/json")
	@ResponseBody
	public String listSoup(@PathVariable("uuid") String uuid) {
		System.out.println(uuid);
		String json = new Gson().toJson(soupService.findByUuid(uuid));
		System.out.println(json);
		return json;
	}
	
	@GetMapping(value="/view/{uuid}", produces = "application/json")
	@ResponseBody
	public List<String> listPalabras(@PathVariable("uuid") String uuid) {
		return soupService.retornaEncontradas(uuid);
	}
	
	@PutMapping("/{uuid}")
	@ResponseBody
	public String validaPalabra(@PathVariable String uuid, @RequestBody Palabra p) {
		String output = null;
		
		Palabra pa = soupService.validaPalabra(uuid, p.getSr(), p.getSc(), p.getEr(), p.getEc());
		System.out.println(pa);
		if ( pa != null) {
			output="CORRECTO, Palabra "+pa.palabra+" encontrada";
			pa.setEncontrada(true);
			soupRepository.save(pa);
		}else {
			output="INCORRECTO, Palabra no existe";
		}				
		return output; 
	}
}












