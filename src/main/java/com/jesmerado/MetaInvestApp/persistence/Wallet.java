package com.jesmerado.MetaInvestApp.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
@Entity
@Table(name = "JESMERADO_WALLETS")
public class Wallet implements Serializable {

    /**
     * SERIAL VERSION
     */
    private static final long serialVersionUID = 1L;

    /**
     * Wallet Id - PK
     */
    private long walletId;

    /**
     * List of user
     */
    private List<User> userList;

    /**
     * List of coins
     */
    private List<Coins> coinsList;

    /**
     * @return the walletId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WALLET_ID")
    public long getWalletId() {
        return walletId;
    }

    /**
     * @param walletId to set.
     */
    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    /**
     * @return the user list.
     */
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "wallet")
    @Column(name = "USER_LIST", nullable = false)
    @RestResource(path = "getUserListAddress", rel = "userListAddress")
    public List<User> getUserList() {
        return userList;
    }

    /**
     * @param userList to set.
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * @return the list of coins.
     */
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "wallet")
    @Fetch(value = FetchMode.SUBSELECT)
    @Column(name = "COIN_LIST", nullable = false)
    @RestResource(path = "getCoinListAddress", rel = "coinListAddress")
    public List<Coins> getCoinsList() {
        return coinsList;
    }

    /**
     * @param coinsList to set.
     */
    public void setCoinsList(List<Coins> coinsList) {
        this.coinsList = coinsList;
    }
}
