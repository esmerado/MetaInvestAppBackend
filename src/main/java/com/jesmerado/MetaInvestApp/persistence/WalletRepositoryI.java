package com.jesmerado.MetaInvestApp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
@Repository
public interface WalletRepositoryI extends JpaRepository<Wallet, Long> {

}
