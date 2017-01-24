/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.business.beans;

import com.concesionario.backend.model.persistence.entities.Venta;
import com.concesionario.backend.model.persistene.facades.VentaFacadeLocal;
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
@Named(value = "ventaManagedbean")
@RequestScoped
public class VentaManagedbean implements Serializable, IManagedBean<Venta> {

    private Venta venta;
    @EJB
    private VentaFacadeLocal vFL;

    public VentaManagedbean() {
    }

    @PostConstruct
    public void init() {
        venta = new Venta();
    }

    @Override
    public Venta getObjectByKey(Integer key) {
        return vFL.find(key);
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void registrarVenta() {
        vFL.create(venta);
    }

    public List<Venta> listarVentas() {
        return vFL.findAll();
    }
    
    public void eliminarVenta(Venta v){
        vFL.remove(v);
    }

}
