package com.jesmerado.MetaInvestApp;

import java.util.ArrayList;
import java.util.List;

import com.jesmerado.MetaInvestApp.persistence.Coins;
import com.jesmerado.MetaInvestApp.persistence.Creator;
import com.jesmerado.MetaInvestApp.services.CoinsManagementServiceI;
import com.jesmerado.MetaInvestApp.services.CreatorManagementServiceI;
import com.jesmerado.MetaInvestApp.services.WalletManagementServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jesmerado.MetaInvestApp.persistence.User;
import com.jesmerado.MetaInvestApp.persistence.Wallet;
import com.jesmerado.MetaInvestApp.services.UserManagementServiceI;

@SpringBootApplication()
public class MetaInvestAppApplication implements CommandLineRunner {

    @Autowired
    public UserManagementServiceI userManagementServiceI;

    @Autowired
    public WalletManagementServiceI walletManagementServiceI;

    @Autowired
    public CoinsManagementServiceI coinsManagementServiceI;

    @Autowired
    public CreatorManagementServiceI creatorManagementServiceI;

    public static void main(String[] args) {
        SpringApplication.run(MetaInvestAppApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        /** LOGER */
        final Logger LOGGER = LoggerFactory.getLogger(MetaInvestAppApplication.class);

        /** Test */
        System.out.println("----------------------------- START --------------------------");
        LOGGER.info("MetaInvestAppApplication -> Insert Users");

        // New User 1.
        User user1 = new User("Javier", "esmerado@gmail.com", "123456", true);

        // New User 2.
        User user2 = new User("Ramos", "ramos@gmail.com", "654321", false);

        // New User 3.
        User user3 = new User("Nadia", "nadia@gmail.com", "98765431", false);

        // New User 4.
        User user4 = new User("Tellez", "tellez@gmail.com", "741258963", false);

        LOGGER.info("MetaInvestAppApplication -> Insert Wallets, Creatos and Coins");
        // New Wallet.
        Wallet wallet = new Wallet();

        // New Wallet 2.
        Wallet wallet2 = new Wallet();

        // New Coin.
        Coins coin = new Coins();

        // New Coin 2.
        Coins coin2 = new Coins();

        // New Coin 3.
        Coins coin3 = new Coins();

        // New Creator.
        Creator creator = new Creator();

        // New Creator 2.
        Creator creator2 = new Creator();

        // Set the wallet to users.
        user1.setWallet(wallet);
        user2.setWallet(wallet);
        user3.setWallet(wallet2);
        user4.setWallet(wallet2);

        // Set the list of users to the wallet.
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        List<User> userList2 = new ArrayList<>();
        userList2.add(user4);
        userList2.add(user3);

        wallet.setUserList(userList);
        wallet2.setUserList(userList2);

        // Set Coins values.
        coin.setWallet(wallet);
        coin.setCoinName("BTC");
        coin.setPrice(66000L);
        coin.setAmount(12L);

        coin2.setWallet(wallet);
        coin2.setCoinName("ETH");
        coin2.setPrice(4000L);
        coin2.setAmount(30L);

        coin3.setWallet(wallet2);
        coin3.setCoinName("ADA");
        coin3.setPrice(2L);
        coin3.setAmount(400L);

        // Set Creator values.
        creator.setName("Elon Musk");

        creator2.setName("Javier Esmerado");

        // Set the list of coins to the wallet.
        List<Coins> coinsList = new ArrayList<>();

        coinsList.add(coin);
        coinsList.add(coin2);

        List<Coins> coinsList2 = new ArrayList<>();

        coinsList2.add(coin3);

        wallet.setCoinsList(coinsList);
        wallet2.setCoinsList(coinsList2);

        // Set the list of coins to the creators
        creator.setCoinsList(coinsList);
        creator2.setCoinsList(coinsList2);

        // Set the creator list to the coins
        List<Creator> creatorList = new ArrayList<>();

        creatorList.add(creator);
        creatorList.add(creator2);

        // Insert wallets to db.
        walletManagementServiceI.newWallet(wallet);
        walletManagementServiceI.newWallet(wallet2);

        // Insert users to db.
        userManagementServiceI.insertUser(user1);
        userManagementServiceI.insertUser(user2);
        userManagementServiceI.insertUser(user3);
        userManagementServiceI.insertUser(user4);


        // Insert coins to db.
        coinsManagementServiceI.insertCoin(coin);
        coinsManagementServiceI.insertCoin(coin2);
        coinsManagementServiceI.insertCoin(coin3);

        // Insert creator to db.
        creatorManagementServiceI.newCreator(creator);
        creatorManagementServiceI.newCreator(creator2);

		/*String name = "TheBest";
		String mail = "";
		String pass = "";
		userManagementServiceI.updateUser(user1, name, mail, pass);*/

        /*walletManagementServiceI.removeWallet(wallet);*/


    }

}
