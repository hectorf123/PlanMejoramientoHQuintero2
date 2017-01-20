/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.business.beans;

import com.concesionario.backend.model.persistence.entities.Vehiculo;
import com.concesionario.backend.model.persistene.facades.VehiculoFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Juank
 */
@Named(value = "vehiculoManagedBean")
@RequestScoped
public class VehiculoManagedBean {

    private Vehiculo vehiculo;
    @EJB
    private VehiculoFacadeLocal vFL;
    private List<Vehiculo> veh;

    public VehiculoManagedBean() {
    }

    @PostConstruct
    public void init() {
        vehiculo = new Vehiculo();

    }

    public List<Vehiculo> getCars() {
        return veh;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void registrarVehiculo() {
        vFL.create(vehiculo);
    }

}
