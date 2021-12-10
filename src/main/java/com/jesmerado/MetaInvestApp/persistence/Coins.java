package com.jesmerado.MetaInvestApp.persistence;

import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
@Entity
@Table(name = "JESMERADO_COINS")
public class Coins implements Serializable {

    /**
     * SERIAL VERSION
     */
    private static final long serialVersionUID = 1L;

    /**
     * Coin Id - PK
     */
    private long coinId;

    /**
     * Coin name
     */
    private String coinName;

    /**
     * Coin price
     */
    private Long price;

    /**
     * Coin Amount
     */
    private Long amount;

    /**
     * Wallet
     */
    private Wallet wallet;

    /**
     * List of creators
     */
    private List<Creator> creatorList;

    /**
     * @return the coinId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getCoinId() {
        return coinId;
    }

    /**
     * @param coinId to set.
     */
    public void setCoinId(long coinId) {
        this.coinId = coinId;
    }

    /**
     * @return the coin name.
     */
    @Column(name = "COIN_NAME", nullable = false)
    public String getCoinName() {
        return coinName;
    }

    /**
     * @param coinName to set.
     */
    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    /**
     * @return the price.
     */
    @Column(name = "PRICE", nullable = false)
    public Long getPrice() {
        return price;
    }

    /**
     * @param price to set.
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return the amount.
     */
    @Column(name = "AMOUNT", nullable = false)
    public Long getAmount() {
        return amount;
    }

    /**
     * @param amount to set.
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * @return the wallet.
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "WALLET_ID")
    @RestResource(path = "walletAdress", rel = "addressCoins")
    public Wallet getWallet() {
        return wallet;
    }

    /**
     * @param wallet to set.
     */
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    /**
     * @return a list of creators.
     */
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "JESMERADO_COIN_CREATOR", joinColumns = {
            @JoinColumn(name = "COIN_ID")}, inverseJoinColumns = {@JoinColumn(name = "CREATOR_ID")})
    public List<Creator> getCreatorList() {
        return creatorList;
    }

    /**
     * @param creatorList to set.
     */
    public void setCreatorList(List<Creator> creatorList) {
        this.creatorList = creatorList;
    }
}
