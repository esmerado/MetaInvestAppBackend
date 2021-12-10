package com.jesmerado.MetaInvestApp.persistence;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
public class UserDaoImpl implements UserDaoI {

    EntityManager em;

    @Override
    public List<User> getUserByMailAndWalletId(String mail, Long walletId) {
        // Consulta Criteria
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<User> cquery = cb.createQuery(User.class);
        final Root<User> rootP = cquery.from(User.class);
        final Join<User, Wallet> pJoinT = rootP.join("wallet");


        // Claúsula where
        final Predicate pr1 = cb.like(pJoinT.getParent().<String>get("mail"), mail);
        final Predicate pr2 = cb.<Long>le(pJoinT.<Long>get("walletId"), walletId);


        // Consulta.
        cquery.select(rootP).where(cb.and(pr1, pr2));


        final List<User> results = em.createQuery(cquery).getResultList();
        return results;
    }
}
