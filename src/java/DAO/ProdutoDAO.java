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
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;
import model.Produto;
import utils.ConnectionFactory;

/**
 *
 * @author fbrcmmelo
 */
public class ProdutoDAO implements GenericDAO {

    private Connection conn;

    public ProdutoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Banco acessado com Sucesso!");
        } catch (Exception ex) {
            System.out.println("Poblemas ao conectar com o BD");
        }
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Produto oProduto = (Produto) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into produto (nome_produto, descricao_produto, foto_produto, id_pessoa)" + "values (?, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oProduto.getNomeProduto());
            stmt.setString(2, oProduto.getDescricaoProduto());
            stmt.setBinaryStream(3, oProduto.getFotoProduto(), oProduto.getFileInt());
            stmt.setInt(4, oProduto.getPessoa().getIdPessoa());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao cadastrar Produto:Erro:" + ex.getMessage());
            return false;
        } finally { //fechar o BD não importa o que aconteça
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problema ao fechar os parametros de conecao! Erro:" + ex.getMessage());
            }
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Produto oProduto = (Produto) objeto;
        PreparedStatement stmt = null;
        String sql = "update produto set nome_produto=?, descricao_produto=?, foto_produto=? where id_produto=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oProduto.getNomeProduto());
            stmt.setString(2, oProduto.getDescricaoProduto());
            stmt.setBinaryStream(3, oProduto.getFotoProduto(), oProduto.getFileInt());
            stmt.setInt(4, oProduto.getIdProduto());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao alterar Produto:Erro:" + ex.getMessage());
            return false;
        } finally { //fechar o BD não importa o que aconteça
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problema ao fechar os parametros de conexao! Erro:" + ex.getMessage());
            }
        }
    }

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "Delete from produto where id_produto = ?;";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Produto, Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    
    public Produto mostrarFoto(int idProduto) {

        Produto oProduto = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.id_produto, p.foto_produto from produto p "
                + "where p.id_produto = ?;";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            rs = stmt.executeQuery();

            if (rs.next()) {
                oProduto = new Produto();
                oProduto.setIdProduto(rs.getInt("id_produto"));
                oProduto.setFotoProduto(rs.getBinaryStream("foto_produto"));
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Foto Produto! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return oProduto;
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto oProduto = null;
        String sql = "select * from produto where id_produto=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oProduto = new Produto();
                oProduto.setIdProduto(rs.getInt("id_produto"));
                oProduto.setNomeProduto(rs.getString("nome_produto"));
                oProduto.setDescricaoProduto(rs.getString("descricao_produto"));
                oProduto.setFotoProduto(rs.getBinaryStream("foto_produto"));
                oProduto.setPessoa(new Pessoa(rs.getInt("id_pessoa")));
            }
           
        } catch (Exception ex) {
            System.out.println("Problema ao carregar Produto:Erro:" + ex.getMessage());
            return false;
        } finally { //fechar o BD não importa o que aconteça
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problema ao fechar os parametros de conn! Erro:" + ex.getMessage());
            }
        }
         return oProduto;
    }

    @Override
    public List<Object> listar() {
        List<Object> lstResultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*,pes.nome_pessoa from produto p, pessoa pes "
                + "where p.id_pessoa = pes.id_pessoa;";// nome da tabela do banco (TUDOMINUSCULO)

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto oProduto = new Produto();
                oProduto.setIdProduto(rs.getInt("id_produto"));
                oProduto.setNomeProduto(rs.getString("nome_produto"));
                oProduto.setDescricaoProduto(rs.getString("descricao_produto"));
                oProduto.setPessoa(new Pessoa(rs.getString("nome_pessoa")));

                lstResultado.add(oProduto);
            }
        } catch (Exception ex) {
            System.out.println("Problema ao carregar Produto:Erro:" + ex.getMessage());
        } finally { //fechar o BD não importa o que aconteça
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problema ao fechar os parametros de conn! Erro:" + ex.getMessage());
            }
        }
        return lstResultado;
    }
}
