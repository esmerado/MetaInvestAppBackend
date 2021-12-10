package com.jesmerado.MetaInvestApp.services;

import com.jesmerado.MetaInvestApp.persistence.Wallet;

import java.util.List;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
public interface WalletManagementServiceI {

    /**
     * Create a new Wallet.
     */
    void newWallet(Wallet wallet);

    /**
     * @return all the wallets.
     */
    List<Wallet> findAll();

    /**
     * Remove a wallet.
     */
    void removeWallet(Wallet wallet);

}
