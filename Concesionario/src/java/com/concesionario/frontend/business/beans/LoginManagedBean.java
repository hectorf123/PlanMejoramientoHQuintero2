/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.business.beans;

import com.concesionario.backend.model.persistence.entities.Concesionario;

import com.concesionario.backend.model.persistene.facades.ConcesionarioFacadeLocal;
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

    private Concesionario concesionario;
    @EJB
    private ConcesionarioFacadeLocal cFL;

    public LoginManagedBean() {
    }

    @PostConstruct
    public void init() {
        concesionario = new Concesionario();
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

    public String iniciarSesion() {
        Concesionario co;
        String redireccionar = null;
        try {
            co = cFL.iniciarSesion(concesionario);
            if (co != null) {
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
