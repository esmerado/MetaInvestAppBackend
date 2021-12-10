package com.jesmerado.MetaInvestApp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
@Repository
public interface UserRepositoryI extends JpaRepository<User, Long> {

    /**
     * @param mail
     * @param password
     * @return the User.
     */
    User findByMailAndPassword(final String mail, final String password);

    /**
     * Find by id.
     *
     * @param entityId
     * @return
     */
    User findByEntityId(final Long entityId);


}
