/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.business.beans;

import com.concesionario.backend.model.persistence.entities.Cliente;
import com.concesionario.backend.model.persistene.facades.ClienteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juank
 */
@Named(value = "clienteManagedBean")
@SessionScoped
public class ClienteManagedBean implements Serializable {

    private Cliente cliente;
    @EJB
    private ClienteFacadeLocal cFL;

    public ClienteManagedBean() {
    }

    @PostConstruct
    public void init() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void registrar() {

        cFL.create(cliente);

    }

}