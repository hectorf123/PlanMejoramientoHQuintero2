/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.utilities.converters;

import com.concesionario.backend.model.persistence.entities.Concesionario;
import com.concesionario.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Juank
 */
@FacesConverter(forClass = Concesionario.class)
public class ConcesionarioConverter extends AbstractConverter {

    public ConcesionarioConverter() {
        this.namedManagedBean="concesionarioManagedBeann";
    }
    
}
