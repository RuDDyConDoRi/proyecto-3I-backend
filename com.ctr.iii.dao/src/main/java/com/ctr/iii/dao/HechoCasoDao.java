package com.ctr.iii.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctr.iii.dominio.HechoCaso;
import com.ctr.iii.dominio.HechoCasoKey;

/**
 * Repository : HechoCaso.
 */
public interface HechoCasoDao extends PagingAndSortingRepository<HechoCaso, HechoCasoKey> {

}
