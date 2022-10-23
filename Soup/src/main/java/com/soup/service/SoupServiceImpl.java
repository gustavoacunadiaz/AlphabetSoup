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
	public List<Palabra> findAll(){
		return (List<Palabra>) soupRepository.findAll();
	}
	
	
	@Override
	public String findByUuid(long uuid) {
		return soupRepository.findByUuid(uuid);
	}
	
	
	@Override
	public String validaPalabra() {
		String output = null;		
		return output;		
	}
		
	
	public SoupServiceImpl(SoupRepository soupRepository) {
		this.soupRepository = soupRepository;
	}
}
