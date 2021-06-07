/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author fbrcmmelo
 */
public class Entrega {
    private int idEntrega;
    private Date dataEntrega;
    private String statusEntrega;

    public Entrega() {
    }

    /**
     * @return the idEntrega
     */
    public int getIdEntrega() {
        return idEntrega;
    }

    /**
     * @param idEntrega the idEntrega to set
     */
    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    /**
     * @return the dataEntrega
     */
    public Date getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * @return the statusEntrega
     */
    public String getStatusEntrega() {
        return statusEntrega;
    }

    /**
     * @param statusEntrega the statusEntrega to set
     */
    public void setStatusEntrega(String statusEntrega) {
        this.statusEntrega = statusEntrega;
    }
    
    
}
