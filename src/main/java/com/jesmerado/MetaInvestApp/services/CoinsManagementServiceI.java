package com.jesmerado.MetaInvestApp.services;

import com.jesmerado.MetaInvestApp.persistence.Coins;

import java.util.List;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
public interface CoinsManagementServiceI {

    /**
     * Create a new Wallet.
     */
    void insertCoin(Coins coin);

    /**
     * @return all the wallets.
     */
    List<Coins> findAll();

    /**
     * Remove a wallet.
     */
    void removeCoins(Coins coin);

}
