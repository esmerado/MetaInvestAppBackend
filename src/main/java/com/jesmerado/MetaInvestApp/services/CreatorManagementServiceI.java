package com.jesmerado.MetaInvestApp.services;

import com.jesmerado.MetaInvestApp.persistence.Creator;

import java.util.List;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
public interface CreatorManagementServiceI {

    /**
     * Create a new Wallet.
     */
    void newCreator(Creator creator);

    /**
     * @return all the wallets.
     */
    List<Creator> findAll();

    /**
     * Remove a wallet.
     */
    void removeCreator(Creator creator);

}
