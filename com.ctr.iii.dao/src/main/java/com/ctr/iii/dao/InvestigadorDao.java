package com.ctr.iii.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctr.iii.dominio.Investigador;

/**
 * Repository : Investigador.
 */
public interface InvestigadorDao extends PagingAndSortingRepository<Investigador, String> {

}
