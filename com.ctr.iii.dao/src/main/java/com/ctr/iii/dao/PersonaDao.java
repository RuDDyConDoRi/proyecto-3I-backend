package com.ctr.iii.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctr.iii.dominio.Persona;

/**
 * Repository : Persona.
 */
public interface PersonaDao extends PagingAndSortingRepository<Persona, String> {

}
