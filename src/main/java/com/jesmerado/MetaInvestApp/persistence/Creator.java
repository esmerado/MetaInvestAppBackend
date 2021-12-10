package com.jesmerado.MetaInvestApp.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
@Entity
@Table(name = "JESMERADO_CREATOR")
public class Creator implements Serializable {

    /**
     * SERIAL VERSION
     */
    private static final long serialVersionUID = 1L;

    /**
     * Coin Id - PK
     */
    private long creatorId;

    /**
     * Creator name
     */
    private String name;

    /**
     * List of coins
     */
    private List<Coins> coinsList;

    /**
     * @return the creatorId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId to set.
     */
    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return the creator name.
     */
    @Column(name = "CREATOR_NAME", nullable = false)
    public String getName() {
        return name;
    }

    /**
     * @param name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return a list of coins.
     */
    @ManyToMany(mappedBy = "creatorList")
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
