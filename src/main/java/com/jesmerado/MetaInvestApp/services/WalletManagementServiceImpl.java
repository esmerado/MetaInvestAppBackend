package com.jesmerado.MetaInvestApp.services;

import com.jesmerado.MetaInvestApp.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
@Service
public class WalletManagementServiceImpl implements WalletManagementServiceI {

    @Autowired
    private WalletRepositoryI walletRepositoryI;

    @Autowired
    private UserRepositoryI userRepositoryI;

    @Autowired
    private CoinsRepositoryI coinsRepositoryI;

    @Override
    public void newWallet(Wallet wallet) {
        walletRepositoryI.saveAndFlush(wallet);
    }

    @Override
    public List<Wallet> findAll() {
        return walletRepositoryI.findAll();
    }

    @Override
    public void removeWallet(Wallet wallet) {
        List<User> usersList = wallet.getUserList();

        for (User user : usersList) {
            user.setWallet(null);
            userRepositoryI.save(user);
        }

        List<Coins> coinList = wallet.getCoinsList();

        for (Coins coin : coinList) {
            coin.setWallet(null);
            coinsRepositoryI.save(coin);
        }

        walletRepositoryI.delete(wallet);
    }
}
