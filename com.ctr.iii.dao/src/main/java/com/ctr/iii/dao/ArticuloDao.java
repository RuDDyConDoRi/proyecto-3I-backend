package com.ctr.iii.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctr.iii.dominio.Articulo;

/**
 * Repository : Articulo.
 */
public interface ArticuloDao extends PagingAndSortingRepository<Articulo, String> {

}
