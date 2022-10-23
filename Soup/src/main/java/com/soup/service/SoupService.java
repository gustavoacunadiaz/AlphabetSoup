package com.soup.service;

import java.util.List;

import com.soup.model.Palabra;
import com.soup.model.Soup;

public interface SoupService {
	
	public List<Palabra> findAll();
	
	public List<String> findByUuid(String uuid);
	
	public List<String> retornaEncontradas(String uuid);
	
	public Palabra validaPalabra(String uuid, Integer sr, Integer sc, Integer er, Integer ec);

	public Soup saveSoup(Soup soup);
	
	public Palabra savePalabra(Palabra palabra);
	
	public void actualizaEstado(Integer id, String uuid);

}
