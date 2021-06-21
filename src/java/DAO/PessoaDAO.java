/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pessoa;
import utils.ConnectionFactory;

/**
 *
 * @author fbrcmmelo
 */
public class PessoaDAO {

    private Connection conn;

    public PessoaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Banco acessado com Sucesso!");
        } catch (Exception ex) {
            System.out.println("Poblemas ao conectar com o BD");
        }
    }

    public Integer cadastrar(Pessoa pessoa) {

        Integer idPessoa = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO pessoa(nome_pessoa, email_pessoa, senha_pessoa, cpf_pessoa, telefone_pessoa, endereco_pessoa,"
                + " tipo_pessoa, id_cidade) VALUES (?, ?, md5(?), ?, ?, ?, ?, ?);";
        String lastinsert = "Select last_insert_id();";
        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getEmailPessoa());
            stmt.setString(3, pessoa.getSenhaPessoa());
            stmt.setString(4, pessoa.getCpfPessoa());
            stmt.setString(5, pessoa.getTelefonePessoa());
            stmt.setString(6, pessoa.getEnderecoPessoa());
            stmt.setString(7, pessoa.getTipoPessoa());
            stmt.setInt(8, pessoa.getCidade().getIdCidade());
            stmt.executeUpdate();
            rs = stmt.executeQuery(lastinsert);

            if (rs.next()) {
                idPessoa = rs.getInt("last_insert_id()");
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Pessoa! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return idPessoa;

    }

    public Boolean alterar(Pessoa pessoa) {
        PreparedStatement stmt = null;
        String sql = "update pessoa set nome_pessoa = ?, email_pessoa = ?,senha_pessoa, cpf_pessoa = ?,"
                + " telefone_pessoa, endereco_pessoa, tipo_pessoa" 
                + " where id_pessoa = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getEmailPessoa());
            stmt.setString(3, pessoa.getSenhaPessoa());
            stmt.setString(4, pessoa.getCpfPessoa());      
            stmt.setString(5, pessoa.getTelefonePessoa());
            stmt.setString(6, pessoa.getEnderecoPessoa());
            stmt.setString(7, pessoa.getTipoPessoa());
            stmt.setInt(8, pessoa.getIdPessoa());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Pessoa! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public Pessoa logarPessoa(String email, String senha) {

        Pessoa pessoa = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT p.* from pessoa p where p.email_pessoa = ? and p.senha_pessoa = md5(?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                pessoa.setNomePessoa(rs.getString("nome_pessoa"));
                pessoa.setEmailPessoa(rs.getString("email_pessoa"));
                pessoa.setSenhaPessoa(rs.getString("senha_pessoa"));
                pessoa.setCpfPessoa(rs.getString("cpf_pessoa"));
                pessoa.setTelefonePessoa(rs.getString("telefone_pessoa"));
                pessoa.setEnderecoPessoa(rs.getString("endereco_pessoa"));
                pessoa.setTipoPessoa(rs.getString("tipo_pessoa"));
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao logar Pessoa! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return pessoa;

    }
}
