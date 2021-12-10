package com.jesmerado.MetaInvestApp.controller;

import com.jesmerado.MetaInvestApp.persistence.Coins;
import com.jesmerado.MetaInvestApp.persistence.User;
import com.jesmerado.MetaInvestApp.services.CoinsManagementServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 *
 */
@RestController
@RequestMapping("/coins")
public class CoinsController {

    @Autowired
    private CoinsManagementServiceI coinsManagementServiceI;

    /**
     *
     * @return a list of coins.
     */
    @GetMapping("/getAll")
    public List<Coins> getAllCoin() {
        return coinsManagementServiceI.findAll();
    }

    /**
     *
     * To add a new coin.
     *
     * @param coins
     * @return
     */
    @PostMapping("/add")
    public String addCoin(@RequestBody Coins coins) {
        coinsManagementServiceI.insertCoin(coins);
        return "New coin is added";
    }

    /**
     *
     * To remove a coin.
     *
     * @param coins
     * @return
     */
    @PostMapping("/remove")
    public String removeCoin(@RequestBody Coins coins) {
        coinsManagementServiceI.removeCoins(coins);
        return "Coin delete";
    }

}
