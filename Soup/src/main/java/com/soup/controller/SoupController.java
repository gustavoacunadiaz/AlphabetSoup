package com.soup.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity createSoup(@RequestBody Soup soup) {	
		String output = null;
	
		if (soup.getW() >= 15 && soup.getW() <= 80) {
			if (soup.getH() >= 15 && soup.getH() <= 80) {	
								
				Soup s = new Soup();
				s.setBtt(soup.isBtt());
				s.setD(soup.isD());
				s.setEstado(false);
				s.setH(soup.getH());
				s.setLtr(soup.isLtr());
				s.setRtl(soup.isRtl());
				s.setTtb(soup.isTtb());
				s.setUuidString(soup.getUuidString());
				s.setW(soup.getW());	
				
				Palabra p1 = new Palabra ("hola",0,0,0,3,s.getUuidString(),false);
				Palabra p2 = new Palabra ("planta",1,0,1,5,s.getUuidString(),false);
				Palabra p3 = new Palabra ("edificio",2,0,2,7,s.getUuidString(),false);
				Palabra p4 = new Palabra ("refrigerador",3,0,3,11,s.getUuidString(),false);
				
				int limiteI = 97;
				int limiteD = 122;
				int ancho = s.getW();
				int largo = s.getH();
				
				Random random = new Random();
				StringBuilder buffer = new StringBuilder(largo);
					
				for (int i = 0; i<largo; i++) {
					for (int j=0; j<ancho; j++) {												
						if (p1.getSr() == i && p1.getSc() == j) {
							buffer.append(p1.palabra);
							j = j + (p1.palabra.length());
						} 				
						if (p2.getSr() == i && p2.getSc() == j) {
							buffer.append(p2.palabra);
							j = j + (p2.palabra.length());
						} 				
						if (p3.getSr() == i && p3.getSc() == j) {
							buffer.append(p3.palabra);
							j = j + (p3.palabra.length());
						} 
						if (p4.getSr() == i && p4.getSc() == j) {
							buffer.append(p4.palabra);
							j = j + (p4.palabra.length());
						} 
						int randomLimit = limiteI + (int) (random.nextFloat() * (limiteD - limiteI + 1));
						buffer.append((char) randomLimit);
					}					
					buffer.append("\n");
				}	
				String stringGenerado = buffer.toString();
				System.out.println(stringGenerado);		
				s.setCadena(stringGenerado);
				
				soupService.saveSoup(s);		
				soupService.savePalabra(p1);
				soupService.savePalabra(p2);
				soupService.savePalabra(p3);
				soupService.savePalabra(p4);
						
				output = "{\"id\":\""+s.getUuidString()+"\"}"; 
				return new ResponseEntity<>(output,HttpStatus.OK);
			
			} else {
				output = "{\"message\":\"Mensaje de error\"}";
				return new ResponseEntity<>(output,HttpStatus.BAD_REQUEST);
			}
		} else {
			
			output = "{\"message\":\"Mensaje de error\"}";
			return new ResponseEntity<>(output,HttpStatus.BAD_REQUEST);
		}
		
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












