/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fbrcmmelo
 */
public class Administrador extends Pessoa {
    private int idAdministrador;
    private String rgAdministrador;

    public Administrador() {
    }

    /**
     * @return the idAdministrador
     */
    public int getIdAdministrador() {
        return idAdministrador;
    }

    /**
     * @param idAdministrador the idAdministrador to set
     */
    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    /**
     * @return the rgAdministrador
     */
    public String getRgAdministrador() {
        return rgAdministrador;
    }

    /**
     * @param rgAdministrador the rgAdministrador to set
     */
    public void setRgAdministrador(String rgAdministrador) {
        this.rgAdministrador = rgAdministrador;
    }
    
    
    
}
