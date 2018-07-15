package com.ctr.iii.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctr.iii.dominio.ElemConviccionConclusion;
import com.ctr.iii.dominio.ElemConviccionConclusionKey;

/**
 * Repository : ElemConviccionConclusion.
 */
public interface ElemConviccionConclusionDao extends PagingAndSortingRepository<ElemConviccionConclusion, ElemConviccionConclusionKey> {

}
