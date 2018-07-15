package com.ctr.iii.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctr.iii.dominio.CasoAgra;
import com.ctr.iii.dominio.CasoAgraKey;

/**
 * Repository : CasoAgra.
 */
public interface CasoAgraDao extends PagingAndSortingRepository<CasoAgra, CasoAgraKey> {

}
