/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.TypeJournal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hp
 */
@Stateless
public class TypeJournalFacade extends AbstractFacade<TypeJournal> {

    @PersistenceContext(unitName = "compta-v3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeJournalFacade() {
        super(TypeJournal.class);
    }
    
}