/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.business.beans;

import com.concesionario.backend.model.persistence.entities.Concesionario;
import com.concesionario.backend.model.persistene.facades.ConcesionarioFacadeLocal;
import com.concesionario.frontend.logica.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Juank
 */
@Named(value = "concesionarioManagedBeann")
@RequestScoped
public class ConcesionarioManagedBeann implements Serializable, IManagedBean<Concesionario> {

    private Concesionario concesionario;
    @EJB
    private ConcesionarioFacadeLocal cFL;

    public ConcesionarioManagedBeann() {
    }

    @PostConstruct
    public void init() {
        concesionario = new Concesionario();
    }

    @Override
    public Concesionario getObjectByKey(Integer key) {
        return cFL.find(key);
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void registrarConcesionario() {
        cFL.create(concesionario);
    }

    public List<Concesionario> listarConcesionario() {
        return cFL.findAll();
    }

}
