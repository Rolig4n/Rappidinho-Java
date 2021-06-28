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
public class Entrega {
    private int idEntrega;
    private Date dataEntrega = new Date();
    private String statusEntrega;
    private Pedido pedido;
    private Rota rota;
    private Contratado contratado;
    private Contratante contratante;
    private Pessoa pessoa;


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

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
     * @return the contratante
     */
    public Contratante getContratante() {
        return contratante;
    }

    /**
     * @param contratante the contratante to set
     */
    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
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
    
    
}
