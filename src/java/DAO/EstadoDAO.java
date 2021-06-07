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
import model.Estado;
import utils.ConnectionFactory;

/**
 *
 * @author fbrcmmelo
 */
public class EstadoDAO implements GenericDAO {

    private Connection conn;

    public EstadoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Banco acessado com Sucesso!");
        } catch (Exception ex) {
            System.out.println("Poblemas ao conectar com o BD");
        }
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Estado oEstado = (Estado) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into estado (nome_estado, sigla_estado) values (?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oEstado.getNomeEstado());
            stmt.setString(2, oEstado.getSiglaEstado());

            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao cadastrar Estado:Erro:" + ex.getMessage());
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
        Estado oEstado = (Estado) objeto;
        PreparedStatement stmt = null;
        String sql = "update estado set nome_estado=?, sigla_estado=? where id_estado=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oEstado.getNomeEstado());
            stmt.setString(2, oEstado.getSiglaEstado());
            stmt.setInt(3, oEstado.getIdEstado());

            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao alterar Estado:Erro:" + ex.getMessage());
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
    public void excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "Delete from estado where id_estado = ?;";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Estado, Erro: " + ex.getMessage());
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

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estado oEstado = null;
        String sql = "select * from estado where id_estado=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oEstado = new Estado();
                oEstado.setIdEstado(rs.getInt("id_estado"));
                oEstado.setNomeEstado(rs.getString("nome_estado"));
                oEstado.setSiglaEstado(rs.getString("sigla_estado"));

            }
            return oEstado;
        } catch (Exception ex) {
            System.out.println("Problema ao carregar Estado:Erro:" + ex.getMessage());
            return false;
        } finally { //fechar o BD não importa o que aconteça
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problema ao fechar os parametros de conn! Erro:" + ex.getMessage());
            }
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> lstResultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from estado order by id_estado";// nome da tabela do banco (TUDOMINUSCULO)

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estado oEstado = new Estado();
                oEstado.setIdEstado(rs.getInt("id_estado"));
                oEstado.setNomeEstado(rs.getString("nome_estado"));
                oEstado.setSiglaEstado(rs.getString("sigla_estado"));

                lstResultado.add(oEstado);
            }
        } catch (Exception ex) {
            System.out.println("Problema ao carregar Estado:Erro:" + ex.getMessage());
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
