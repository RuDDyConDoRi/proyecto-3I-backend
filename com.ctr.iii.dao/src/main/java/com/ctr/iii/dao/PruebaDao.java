package com.ctr.iii.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctr.iii.dominio.Prueba;
import com.ctr.iii.dominio.PruebaKey;

/**
 * Repository : Prueba.
 */
public interface PruebaDao extends PagingAndSortingRepository<Prueba, PruebaKey> {

}
