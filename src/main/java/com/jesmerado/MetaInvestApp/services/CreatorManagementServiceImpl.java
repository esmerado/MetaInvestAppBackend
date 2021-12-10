package com.jesmerado.MetaInvestApp.services;

import com.jesmerado.MetaInvestApp.persistence.Creator;
import com.jesmerado.MetaInvestApp.persistence.CreatorRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
@Service
public class CreatorManagementServiceImpl implements CreatorManagementServiceI {


    @Autowired
    private CreatorRepositoryI creatorRepositoryI;

    @Override
    public void newCreator(Creator creator) {
        creatorRepositoryI.saveAndFlush(creator);
    }

    @Override
    public List<Creator> findAll() {
        return creatorRepositoryI.findAll();
    }

    @Override
    public void removeCreator(Creator creator) {
        creatorRepositoryI.delete(creator);
    }
}
