package com.jesmerado.MetaInvestApp.controller;

import com.jesmerado.MetaInvestApp.persistence.Coins;
import com.jesmerado.MetaInvestApp.persistence.User;
import com.jesmerado.MetaInvestApp.persistence.Wallet;
import com.jesmerado.MetaInvestApp.services.WalletManagementServiceI;
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
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletManagementServiceI walletManagementServiceI;

    /**
     *
     * @return a list of wallets.
     */
    @GetMapping("/getAll")
    public List<Wallet> getAllWallet() {
        return walletManagementServiceI.findAll();
    }

    @PostMapping("/add")
    public String addWallet(@RequestBody Wallet wallet) {
        walletManagementServiceI.newWallet(wallet);
        return "New wallet is added";
    }

    @PostMapping("/remove")
    public String removeWallet(@RequestBody Wallet wallet) {
        walletManagementServiceI.removeWallet(wallet);
        return "Wallet delete";
    }

    @PostMapping("/addUserToList")
    public String addUserToList(@RequestBody Wallet wallet, User user){
        wallet.getUserList().add(user);
        return "Coin added";
    }



}
