/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.business.beans;

import com.concesionario.backend.model.persistence.entities.Cliente;
import com.concesionario.backend.model.persistene.facades.ClienteFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Juank
 */
@Named(value = "loginManagedBean")
@ViewScoped
public class LoginManagedBean implements Serializable {

    private Cliente cliente;
    @EJB
    private ClienteFacadeLocal cFL;

    public LoginManagedBean() {
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

    public String iniciarSesion() {
        Cliente c;
        String redireccionar = null;
        try {
            c = cFL.iniciarSesion(cliente);
            if (c != null) {
                redireccionar = "/Pages/inicio";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "El usuario o la clave son incorrectas."));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Ocurrió un error inténtelo más tarde"));
        }
        return redireccionar;
    }

}
