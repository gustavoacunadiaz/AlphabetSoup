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

	@Query(value="SELECT palabra FROM palabras p WHERE p.uuid =:p_uuid", nativeQuery = true)
	public String findByUuid(@Param("p_uuid") long p_uuid);
}
