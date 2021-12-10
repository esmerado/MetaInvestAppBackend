package com.jesmerado.MetaInvestApp.services;

import com.jesmerado.MetaInvestApp.persistence.Coins;
import com.jesmerado.MetaInvestApp.persistence.CoinsRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
@Service
public class CoinsManagementServiceImpl implements CoinsManagementServiceI {

    @Autowired
    private CoinsRepositoryI coinsRepositoryI;

    @Override
    public void insertCoin(Coins coin) {
        coinsRepositoryI.saveAndFlush(coin);
    }

    @Override
    public List<Coins> findAll() {
        return findAll();
    }

    @Override
    public void removeCoins(Coins coin) {
        coinsRepositoryI.delete(coin);
    }
}
