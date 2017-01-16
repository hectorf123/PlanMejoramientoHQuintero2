/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.backend.model.persistene.facades;

import com.concesionario.backend.model.persistence.entities.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juank
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "ConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public Cliente iniciarSesion(Cliente c) {
        Cliente cliente = null;
        String consulta;
        try {
            consulta = "FROM Cliente c WHERE c.nombre = ?1 and c.clave = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, c.getNombre());
            query.setParameter(2, c.getClave());
            List<Cliente> lista = query.getResultList();
            if (!lista.isEmpty()) {
                cliente = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return cliente;
    }

}
