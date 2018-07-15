package com.ctr.iii.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctr.iii.dominio.Caso;

/**
 * Repository : Caso.
 */
public interface CasoDao extends PagingAndSortingRepository<Caso, String> {

}
