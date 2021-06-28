/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author fbrcmmelo
 */
public class Pedido {
    private Integer idPedido;
    private Date dataPedido = new Date();
    private Double latDestinoPedido;
    private Double lngDestinoPedido;
    private String statusPedido;
    private Contratado contratado;
    private Rota rota;
    private Produto produto;
    private Pessoa pessoa;
    
    public Pedido() {
    }
    
    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    
    public Pedido(double latDestinoPedido, double lngDestinoPedido) {
      this.latDestinoPedido = latDestinoPedido;
      this.lngDestinoPedido = lngDestinoPedido;
    }


    public Pedido(Integer idPedido, java.sql.Date dataPedido, double latDestinoPedido, double lngDestinoPedido) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.latDestinoPedido = latDestinoPedido;
        this.lngDestinoPedido = lngDestinoPedido;
    }

    /**
     * @return the idPedido
     */
    public Integer getIdPedido() {
        return idPedido;
    }
    
    public Pedido(Date dataPedido){
        this.dataPedido = dataPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
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

    /**
     * @return the contratado
     */
    public Contratado getContratado() {
        return contratado;
    }

    /**
     * @param contratado the contratado to set
     */
    public void setContratado(Contratado contratado) {
        this.contratado = contratado;
    }

    /**
     * @return the rota
     */
    public Rota getRota() {
        return rota;
    }

    /**
     * @param rota the rota to set
     */
    public void setRota(Rota rota) {
        this.rota = rota;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
    
    
}
