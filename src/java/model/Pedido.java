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
public class Pedido {
    private int idPedido;
    private Date dataPedido;
    private Double latDestinoPedido;
    private Double lngDestinoPedido;
    private String statusPedido;

    public Pedido() {
    }

    /**
     * @return the idPedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the dataPedido
     */
    public Date getDataPedido() {
        return dataPedido;
    }

    /**
     * @param dataPedido the dataPedido to set
     */
    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    /**
     * @return the latDestinoPedido
     */
    public Double getLatDestinoPedido() {
        return latDestinoPedido;
    }

    /**
     * @param latDestinoPedido the latDestinoPedido to set
     */
    public void setLatDestinoPedido(Double latDestinoPedido) {
        this.latDestinoPedido = latDestinoPedido;
    }

    /**
     * @return the lngDestinoPedido
     */
    public Double getLngDestinoPedido() {
        return lngDestinoPedido;
    }

    /**
     * @param lngDestinoPedido the lngDestinoPedido to set
     */
    public void setLngDestinoPedido(Double lngDestinoPedido) {
        this.lngDestinoPedido = lngDestinoPedido;
    }

    /**
     * @return the statusPedido
     */
    public String getStatusPedido() {
        return statusPedido;
    }

    /**
     * @param statusPedido the statusPedido to set
     */
    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
    
    
}
