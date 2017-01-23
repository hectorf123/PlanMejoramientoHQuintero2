/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.utilities.converters;

import com.concesionario.backend.model.persistence.entities.Venta;
import com.concesionario.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Juank
 */
@FacesConverter(forClass = Venta.class)
public class VentaConverter extends AbstractConverter {

    public VentaConverter() {
        this.namedManagedBean = "ventaManagedbean";
    }

}
