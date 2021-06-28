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
public class Produto {
 private Integer idProduto;
 private String nomeProduto;
 private String descricaoProduto;
 private InputStream fotoProduto;
 private int fileInt;
 private Pessoa pessoa;

    public Produto() {
    }

    public Produto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(int idProduto, String nomeProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the idProduto
     */
    public Integer getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    /**
     * @return the fotoProduto
     */
    public InputStream getFotoProduto() {
        return fotoProduto;
    }

    /**
     * @param fotoProduto the fotoProduto to set
     */
    public void setFotoProduto(InputStream fotoProduto) {
        this.fotoProduto = fotoProduto;
    }

    /**
     * @param fileInt the fileInt to set
     */
    public void setFileInt(int fileInt) {
        this.fileInt = fileInt;
    }

    /**
     * @return the fileInt
     */
    public int getFileInt() {
        return fileInt;
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
