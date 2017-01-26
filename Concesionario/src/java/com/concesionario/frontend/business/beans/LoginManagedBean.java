/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.business.beans;

import com.concesionario.backend.model.persistence.entities.Concesionario;

import com.concesionario.backend.model.persistene.facades.ConcesionarioFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Juank
 */
@Named(value = "loginManagedBean")
@RequestScoped
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

    public void cerrarSession() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
    }

    public void redirecionarInicio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicio.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redireccionarReporte() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("reportes.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redireccionarVenta() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("ventas.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redireccionarCliente() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("usuario.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void redireccionarConsulta(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("prueba.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
