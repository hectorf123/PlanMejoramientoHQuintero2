/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.business.beans;

import com.concesionario.backend.model.persistence.entities.Vehiculo;
import com.concesionario.backend.model.persistene.facades.VehiculoFacadeLocal;
import com.concesionario.frontend.logica.IManagedBean;
import java.io.Serializable;
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
public class VehiculoManagedBean implements Serializable, IManagedBean<Vehiculo> {

    private Vehiculo vehiculo;
    @EJB
    private VehiculoFacadeLocal vFL;
    private int precio;
    private List<Vehiculo> pruebaCon;

    public VehiculoManagedBean() {
    }

    @PostConstruct
    public void init() {
        vehiculo = new Vehiculo();
    }

    @Override
    public Vehiculo getObjectByKey(Integer key) {
        return vFL.find(key);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<Vehiculo> getPruebaCon() {
        return pruebaCon;
    }

    public void setPruebaCon(List<Vehiculo> pruebaCon) {
        this.pruebaCon = pruebaCon;
    }

    public void registrarVehiculo() {
        vFL.create(vehiculo);
    }

    public List<Vehiculo> listarVehiculo() {
        return vFL.findAll();
    }
    
    public void consultarPrecio(){
        pruebaCon =vFL.consultaVehiculo(precio);
    }

}
