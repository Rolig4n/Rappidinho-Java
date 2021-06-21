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
public class Contratante extends Pessoa {
    private int idContratante;
    private InputStream fotoContratante;
    private int fileInt;

    public Contratante() {
    }

    /**
     * @return the idContratante
     */
    public int getIdContratante() {
        return idContratante;
    }

    /**
     * @param idContratante the idContratante to set
     */
    public void setIdContratante(int idContratante) {
        this.idContratante = idContratante;
    }

    /**
     * @return the fotoContratante
     */
    public InputStream getFotoContratante() {
        return fotoContratante;
    }

    /**
     * @param fotoContratante the fotoContratante to set
     */
    public void setFotoContratante(InputStream fotoContratante) {
        this.fotoContratante = fotoContratante;
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
