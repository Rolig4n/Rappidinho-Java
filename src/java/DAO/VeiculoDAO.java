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
import model.Contratado;
import model.Pessoa;
import model.Veiculo;
import utils.ConnectionFactory;

/**
 *
 * @author fbrcmmelo
 */
public class VeiculoDAO implements GenericDAO {

    private Connection conn;

    public VeiculoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Banco acessado com Sucesso!");
        } catch (Exception ex) {
            System.out.println("Poblemas ao conectar com o BD");
        }
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into veiculo (nome_veiculo, renavam_veiculo, tipo_veiculo, id_pessoa) values (?, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oVeiculo.getNomeVeiculo());
            stmt.setString(2, oVeiculo.getRenavamVeiculo());
            stmt.setString(3, oVeiculo.getTipoVeiculo());
            stmt.setInt(4,  oVeiculo.getContratado().getIdContratado());

            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao cadastrar Veiculo:Erro:" + ex.getMessage());
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
    public Boolean alterar(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        PreparedStatement stmt = null;
        String sql = "update veiculo set nome_veiculo=?, renavam_veiculo=?, tipo_veiculo=? where id_veiculo=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oVeiculo.getNomeVeiculo());
            stmt.setString(2, oVeiculo.getRenavamVeiculo());
            stmt.setString(3, oVeiculo.getTipoVeiculo());
            stmt.setInt(4, oVeiculo.getIdVeiculo());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao alterar Veiculo:Erro:" + ex.getMessage());
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
        String sql = "Delete from veiculo where id_veiculo = ?;";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Veiculo, Erro: " + ex.getMessage());
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
        Veiculo oVeiculo = null;
        String sql = "select * from veiculo where id_veiculo=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oVeiculo = new Veiculo();
                oVeiculo.setIdVeiculo(rs.getInt("id_veiculo"));
                oVeiculo.setNomeVeiculo(rs.getString("nome_veiculo"));
                oVeiculo.setRenavamVeiculo(rs.getString("renavam_veiculo"));
                oVeiculo.setTipoVeiculo(rs.getString("tipo_veiculo"));
            }
            return oVeiculo;
        } catch (Exception ex) {
            System.out.println("Problema ao carregar Veiculo:Erro:" + ex.getMessage());
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
        String sql = "select v.*, c.id_pessoa, pes.nome_pessoa from veiculo v, contratado c, pessoa pes "
                + "where v.id_pessoa = c.id_pessoa and c.id_pessoa = pes.id_pessoa;";// nome da tabela do banco (TUDOMINUSCULO)

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo oVeiculo = new Veiculo();
                oVeiculo.setIdVeiculo(rs.getInt("id_veiculo"));
                oVeiculo.setNomeVeiculo(rs.getString("nome_veiculo"));
                oVeiculo.setRenavamVeiculo(rs.getString("renavam_veiculo"));
                oVeiculo.setTipoVeiculo(rs.getString("tipo_veiculo"));
                oVeiculo.setContratado(new Contratado(rs.getInt("id_pessoa")));
                oVeiculo.setPessoa(new Pessoa(rs.getString("nome_pessoa")));

                lstResultado.add(oVeiculo);
            }
        } catch (Exception ex) {
            System.out.println("Problema ao carregar Veiculo:Erro:" + ex.getMessage());
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
