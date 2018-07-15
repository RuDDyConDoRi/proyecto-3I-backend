package com.ctr.iii.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctr.iii.dominio.RevisExpediente;
import com.ctr.iii.dominio.RevisExpedienteKey;

/**
 * Repository : RevisExpediente.
 */
public interface RevisExpedienteDao extends PagingAndSortingRepository<RevisExpediente, RevisExpedienteKey> {

}
