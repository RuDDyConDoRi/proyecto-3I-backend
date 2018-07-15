package com.ctr.iii.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctr.iii.dominio.RevisCuadernoInves;
import com.ctr.iii.dominio.RevisCuadernoInvesKey;

/**
 * Repository : RevisCuadernoInves.
 */
public interface RevisCuadernoInvesDao extends PagingAndSortingRepository<RevisCuadernoInves, RevisCuadernoInvesKey> {

}
