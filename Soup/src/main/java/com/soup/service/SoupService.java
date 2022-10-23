package com.soup.service;

import java.util.List;

import com.soup.model.Palabra;
import com.soup.model.Soup;

public interface SoupService {
	
	public List<Palabra> findAll();
	
	public String findByUuid(long uuid);
	
	public String validaPalabra();

}
