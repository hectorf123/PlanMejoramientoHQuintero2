/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.logica;

import com.concesionario.backend.model.persistence.entities.Dto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Juaank
 */
public abstract class AbstractConverter implements Converter {

    protected String namedManagedBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Integer key = Integer.valueOf(value);
            IManagedBean managedBean = (IManagedBean) context.getApplication().getELResolver().getValue(context.getELContext(), null, namedManagedBean);
            return managedBean.getObjectByKey(key);
        } catch (NumberFormatException e) {
            context.addMessage(null, new FacesMessage("Error al implementar el managed bean" + e.getMessage()));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            if (value instanceof Dto) {
                Dto objetoEntity = (Dto) value;
                return objetoEntity.getPK();
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error al convertir a String" + e.getMessage()));
        }
        return null;
    }

}
