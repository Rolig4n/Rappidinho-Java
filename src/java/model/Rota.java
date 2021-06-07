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
public class Rota {
    
 private int idRota;
 private String nomeRota;
 private Double latSaidaRota;
 private Double lngSaidaRota;
 private Double latChegadaRota;
 private Double lngChegadaRota;
 private String statusRota;

    public Rota() {
    }

    /**
     * @return the idRota
     */
    public int getIdRota() {
        return idRota;
    }

    /**
     * @param idRota the idRota to set
     */
    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    /**
     * @return the nomeRota
     */
    public String getNomeRota() {
        return nomeRota;
    }

    /**
     * @param nomeRota the nomeRota to set
     */
    public void setNomeRota(String nomeRota) {
        this.nomeRota = nomeRota;
    }

    /**
     * @return the latSaidaRota
     */
    public Double getLatSaidaRota() {
        return latSaidaRota;
    }

    /**
     * @param latSaidaRota the latSaidaRota to set
     */
    public void setLatSaidaRota(Double latSaidaRota) {
        this.latSaidaRota = latSaidaRota;
    }

    /**
     * @return the lngSaidaRota
     */
    public Double getLngSaidaRota() {
        return lngSaidaRota;
    }

    /**
     * @param lngSaidaRota the lngSaidaRota to set
     */
    public void setLngSaidaRota(Double lngSaidaRota) {
        this.lngSaidaRota = lngSaidaRota;
    }

    /**
     * @return the latChegadaRota
     */
    public Double getLatChegadaRota() {
        return latChegadaRota;
    }

    /**
     * @param latChegadaRota the latChegadaRota to set
     */
    public void setLatChegadaRota(Double latChegadaRota) {
        this.latChegadaRota = latChegadaRota;
    }

    /**
     * @return the lngChegadaRota
     */
    public Double getLngChegadaRota() {
        return lngChegadaRota;
    }

    /**
     * @param lngChegadaRota the lngChegadaRota to set
     */
    public void setLngChegadaRota(Double lngChegadaRota) {
        this.lngChegadaRota = lngChegadaRota;
    }

    /**
     * @return the statusRota
     */
    public String getStatusRota() {
        return statusRota;
    }

    /**
     * @param statusRota the statusRota to set
     */
    public void setStatusRota(String statusRota) {
        this.statusRota = statusRota;
    }
 
 
    
}
