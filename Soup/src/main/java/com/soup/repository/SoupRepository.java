package com.soup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soup.model.Palabra;
import com.soup.model.Soup;

@Repository
public interface SoupRepository extends CrudRepository <Palabra, String>{

	@Query(value="SELECT palabra FROM palabras WHERE uuid =:p_uuid", nativeQuery = true)
	public List<String> findByUuid(@Param("p_uuid") String p_uuid);

	public Soup save(Soup soup);
	
	public Palabra save(Palabra palabra);
	
	@Query(value="SELECT * FROM palabras WHERE uuid=:p_uuid AND sr=:p_sr AND sc=:p_sc AND er=:p_er AND ec=:p_ec", nativeQuery = true)
	public Palabra buscaPalabraByFiltro(@Param("p_uuid") String p_uuid, @Param("p_sr") Integer p_sr, @Param("p_sc") Integer p_sc, @Param("p_er") Integer p_er, @Param("p_ec") Integer p_ec);
	
	@Query(value="UPDATE sopadeletras.palabras SET encontrada = TRUE WHERE id =:p_iid AND uuid =:p_uuid ", nativeQuery = true)
	public void actualizaEstado(@Param("p_iid") Integer p_iid, @Param("p_uuid") String p_uuid);
	
	@Query(value="SELECT palabra FROM palabras WHERE encontrada = 1 AND uuid =:p_uuid", nativeQuery = true)
	public List<String> retornaEncontradas(@Param("p_uuid") String p_uuid);
}
