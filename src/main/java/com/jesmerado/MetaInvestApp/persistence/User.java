package com.jesmerado.MetaInvestApp.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
@Entity
@Table(name = "JESMERADO_USERS")
public class User implements Serializable {

    /**
     * SERIAL VERSION
     */
    private static final long serialVersionUID = 1L;

    /**
     * Entity Id - PK
     */
    private long entityId;

    /**
     * Name
     */
    private String name;

    /**
     * Mail
     */
    private String mail;

    /**
     * Password
     */
    private String password;

    /**
     * Admin
     */
    private boolean isAdmin;

    /**
     * Wallet
     */
    private Wallet wallet;

    public User() {

    }

    /**
     * @param name
     * @param mail
     * @param password
     * @param isAdmin
     */
    public User(String name, String mail, String password, boolean isAdmin) {
        super();
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    /**
     * @return the EntityId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getEntityId() {
        return entityId;
    }

    /**
     * @param entityId to set.
     */
    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    /**
     * @return the name.
     */
    @Column(name = "NAME", nullable = false)
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
     * @return the mail.
     */
    @Column(name = "MAIL", nullable = false)
    public String getMail() {
        return mail;
    }

    /**
     * @param mail to set.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the password.
     */
    @Column(name = "PASSWORD", nullable = false)
    public String getPassword() {
        return password;
    }

    /**
     * @param password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return if the user is admin.
     */
    @Column(name = "ISADMIN", nullable = false)
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin to set.
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return the wallet.
     */
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "WALLET_ID")
    @RestResource(path = "walletAddress", rel = "address")
    public Wallet getWallet() {
        return wallet;
    }

    /**
     * @param wallet to set.
     */
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }


    @Override
    public String toString() {
        return "User{" +
                "entityId=" + entityId +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", wallet=" + wallet +
                '}';
    }
}
