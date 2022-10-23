package com.soup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soup.model.Palabra;
import com.soup.model.Soup;
import com.soup.repository.SoupRepository;

@Service
public class SoupServiceImpl implements SoupService{
	@Autowired
	private SoupRepository soupRepository;
		
	@Override
	public Soup saveSoup(Soup soup) {
		return soupRepository.save(soup);
	}
	
	@Override
	public Palabra savePalabra(Palabra palabra) {
		return soupRepository.save(palabra);
	}
		
	@Override
	public List<Palabra> findAll(){
		return (List<Palabra>) soupRepository.findAll();
	}	
	
	@Override
	public List<String> findByUuid(String uuid) {
		return soupRepository.findByUuid(uuid);
	}
	
	@Override
	public List<String> retornaEncontradas(String uuid) {
		System.out.println(uuid);
		return soupRepository.retornaEncontradas(uuid);
	}
	
	@Override
	public Palabra validaPalabra(String uuid, Integer sr, Integer sc, Integer er, Integer ec) {
		return soupRepository.buscaPalabraByFiltro(uuid, sr, sc, er, ec);	
	}
	
	
	@Override
	public void actualizaEstado(Integer id, String uuid) {
		soupRepository.actualizaEstado(id, uuid);
	}
	
	
	public SoupServiceImpl(SoupRepository soupRepository) {
		this.soupRepository = soupRepository;
	}
}
