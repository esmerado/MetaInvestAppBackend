package com.jesmerado.MetaInvestApp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * MetaInvest App - Javier Esmerado Vela
 * 
 * @author esmer
 *
 */
@Repository
public interface CoinsRepositoryI extends JpaRepository<Coins, Long> {

}
