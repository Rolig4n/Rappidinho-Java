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
public class Pessoa {
        
    private int idPessoa;
    private String nomePessoa;
    private String emailPessoa;
    private String senhaPessoa;
    private String cpfPessoa;
    private String telefonePessoa;
    private String enderecoPessoa;
    private String tipoPessoa;
    private Cidade cidade;
    
    
    public Pessoa() {
    }

    /**
     * @return the idPessoa
     */
    public int getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * @return the nomePessoa
     */
    public String getNomePessoa() {
        return nomePessoa;
    }

    /**
     * @param nomePessoa the nomePessoa to set
     */
    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    /**
     * @return the emailPessoa
     */
    public String getEmailPessoa() {
        return emailPessoa;
    }

    /**
     * @param emailPessoa the emailPessoa to set
     */
    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    /**
     * @return the senhaPessoa
     */
    public String getSenhaPessoa() {
        return senhaPessoa;
    }

    /**
     * @param senhaPessoa the senhaPessoa to set
     */
    public void setSenhaPessoa(String senhaPessoa) {
        this.senhaPessoa = senhaPessoa;
    }

    /**
     * @return the cpfPessoa
     */
    public String getCpfPessoa() {
        return cpfPessoa;
    }

    /**
     * @param cpfPessoa the cpfPessoa to set
     */
    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    /**
     * @return the telefonePessoa
     */
    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    /**
     * @param telefonePessoa the telefonePessoa to set
     */
    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    /**
     * @return the enderecoPessoa
     */
    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    /**
     * @param enderecoPessoa the enderecoPessoa to set
     */
    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    /**
     * @return the tipoPessoa
     */
    public String getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * @param tipoPessoa the tipoPessoa to set
     */
    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    
}
