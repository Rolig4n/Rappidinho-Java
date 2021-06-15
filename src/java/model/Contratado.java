/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.InputStream;

/**
 *
 * @author fbrcmmelo
 */
public class Contratado extends Pessoa{
    private int idContratado;
    private InputStream fotoContratado;
    private String cnhContratado;
    private int fileInt;

    public Contratado() {
    }

    /**
     * @return the idContratado
     */
    public int getIdContratado() {
        return idContratado;
    }

    /**
     * @param idContratado the idContratado to set
     */
    public void setIdContratado(int idContratado) {
        this.idContratado = idContratado;
    }

    /**
     * @return the fotoContratado
     */
    public InputStream getFotoContratado() {
        return fotoContratado;
    }

    /**
     * @param fotoContratado the fotoContratado to set
     */
    public void setFotoContratado(InputStream fotoContratado) {
        this.fotoContratado = fotoContratado;
    }

    /**
     * @return the cnhContratado
     */
    public String getCnhContratado() {
        return cnhContratado;
    }

    /**
     * @param cnhContratado the cnhContratado to set
     */
    public void setCnhContratado(String cnhContratado) {
        this.cnhContratado = cnhContratado;
    }

    /**
     * @return the fileInt
     */
    public int getFileInt() {
        return fileInt;
    }

    /**
     * @param fileInt the fileInt to set
     */
    public void setFileInt(int fileInt) {
        this.fileInt = fileInt;
    }
    
    
    
}
