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
import java.sql.Date;
import java.util.List;
import model.Contratado;
import model.Contratante;
import model.Entrega;
import model.Pedido;
import model.Pessoa;
import model.Produto;
import model.Rota;
import utils.ConnectionFactory;

/**
 *
 * @author fbrcmmelo
 */
public class EntregaDAO implements GenericDAO {

    private Connection conn;

    public EntregaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com o BD com sucesso !");
        } catch (Exception ex) {
            throw new Exception("Problemas ao conectar o Bd Man Erro " + ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Entrega oEntrega = (Entrega) object;
        PreparedStatement stmt = null;
        String sql = "insert into entrega (data_entrega, status_entrega, id_contratado, id_pedido) values (?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(oEntrega.getDataEntrega().getTime()));
            stmt.setString(2, oEntrega.getStatusEntrega());
            stmt.setInt(3, oEntrega.getContratado().getIdContratado());
            stmt.setInt(4, oEntrega.getPedido().getIdPedido());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao Cadastrar Entrega " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de Conexao " + ex.getMessage());
            }
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select e.*,p.*,pro.id_produto,pro.nome_produto,c.id_contratado,pes.nome_pessoa, r.id_rota, r.nome_rota from entrega e, pedido p, produto pro,\n"
                + "contratado c, rota r, pessoa pes where e.id_pedido = p.id_pedido and p.id_contratado = c.id_contratado and p.id_rota = r.id_rota and \n"
                + "p.id_produto = pro.id_produto and pes.id_pessoa = c.id_pessoa order by e.id_entrega;";// nome da tabela do banco (TUDOMINUSCULO)

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Entrega entrega = new Entrega();
                entrega.setIdEntrega(rs.getInt("id_entrega"));
                entrega.setDataEntrega(rs.getDate("data_entrega"));
                entrega.setStatusEntrega(rs.getString("status_entrega"));
                entrega.setContratado(new Contratado(rs.getInt("id_contratado")));
                entrega.setPedido(new Pedido(rs.getInt("id_pedido")));
                /*entrega.setLatDestinoPedido(rs.getDouble("lat_destino_pedido"));
                entrega.setLngDestinoPedido(rs.getDouble("lng_destino_pedido"));
                entrega.setStatusPedido(rs.getString("status_pedido"));
                entrega.setProduto(new Produto(rs.getInt("id_produto"), rs.getString("nome_produto"))); 
                pedido.setPessoa(new Pessoa(rs.getString("nome_pessoa")));
                pedido.setRota(new Rota(rs.getInt("id_rota"), rs.getString("nome_rota")));*/
                resultado.add(entrega);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao listar pedido! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return resultado;

    }

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "Delete from entrega where id_entrega = ?;";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Entrega, Erro: " + ex.getMessage());
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
        Entrega entrega = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select e.*,p.*,pro.id_produto,pro.nome_produto,c.id_contratado,pes.nome_pessoa, r.id_rota, r.nome_rota from entrega e, pedido p, produto pro,\n"
                + "contratado c, rota r, pessoa pes where e.id_pedido = p.id_pedido and p.id_contratado = c.id_contratado and p.id_rota = r.id_rota and \n"
                + "p.id_produto = pro.id_produto and pes.id_pessoa = c.id_pessoa and e.id_entrega = ?;";// nome da tabela do banco (TUDOMINUSCULO)

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                entrega = new Entrega();
                entrega.setIdEntrega(rs.getInt("id_entrega"));
                entrega.setDataEntrega(rs.getDate("data_entrega"));
                entrega.setStatusEntrega(rs.getString("status_entrega"));
                entrega.setContratado(new Contratado(rs.getInt("id_contratado")));
                entrega.setPedido(new Pedido(rs.getInt("id_pedido")));
                /*entrega.setLatDestinoPedido(rs.getDouble("lat_destino_pedido"));
                entrega.setLngDestinoPedido(rs.getDouble("lng_destino_pedido"));
                entrega.setStatusPedido(rs.getString("status_pedido"));
                entrega.setProduto(new Produto(rs.getInt("id_produto"), rs.getString("nome_produto"))); 
                pedido.setPessoa(new Pessoa(rs.getString("nome_pessoa")));
                pedido.setRota(new Rota(rs.getInt("id_rota"), rs.getString("nome_rota")));*/

            }
            return entrega;
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar pedido! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Boolean alterar(Object object) {
        Entrega oEntrega = (Entrega) object;
        PreparedStatement stmt = null;
        String sql = "update entrega set data_entrega=?, status_entrega=? , id_contratado = ?, id_pedido = ? where id_entrega=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(oEntrega.getDataEntrega().getTime()));
            stmt.setString(2, oEntrega.getStatusEntrega());
            stmt.setInt(3, oEntrega.getContratado().getIdContratado());
            stmt.setInt(4, oEntrega.getPedido().getIdPedido());
            stmt.setInt(5, oEntrega.getIdEntrega());
            stmt.executeUpdate();
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

    public Boolean alterarStatusEntrega(int idEntrega, String statusEntrega) {
        Entrega oEntrega = new Entrega();
        long dataEntrega = oEntrega.getDataEntrega().getTime();
        PreparedStatement stmt = null;
        String sql = "UPDATE entrega SET status_entrega = ?, data_entrega = ? WHERE id_entrega = ?;";
        
        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, statusEntrega);
            stmt.setDate(2, new java.sql.Date(dataEntrega));
            stmt.setInt(3, idEntrega);
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar status Entrega! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }
}
