package com.jesmerado.MetaInvestApp.persistence;

import java.util.List;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
public interface UserDaoI {

    /**
     * Búsqueda de usuario a través de su mail y wallet id.
     *
     * @param mail
     * @param walletId
     * @return
     */
    List<User> getUserByMailAndWalletId(final String mail, final Long walletId);

}
