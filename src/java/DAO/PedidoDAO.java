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
import model.Pedido;
import model.Pessoa;
import model.Produto;
import model.Rota;
import utils.ConnectionFactory;

/**
 *
 * @author fbrcmmelo
 */
public class PedidoDAO implements GenericDAO {

    private Connection conn;

    public PedidoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!!!");
        } catch (Exception ex) {
            throw new Exception("Deu ruim ao conectar brother! Erro: " + ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Pedido oPedido = (Pedido) object;
        PreparedStatement stmt = null;

        String sql = "insert into pedido(data_pedido, lat_destino_pedido, lng_destino_pedido, status_pedido, id_produto, "
                + "id_pessoa, id_contratado, id_rota) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(oPedido.getDataPedido().getTime()));
            stmt.setDouble(2, oPedido.getLatDestinoPedido());
            stmt.setDouble(3, oPedido.getLngDestinoPedido());
            stmt.setString(4, oPedido.getStatusPedido());
            stmt.setInt(5, oPedido.getProduto().getIdProduto());
            stmt.setInt(6, oPedido.getPessoa().getIdPessoa());
            stmt.setInt(7, oPedido.getContratado().getIdContratado());
            stmt.setInt(8, oPedido.getRota().getIdRota());
            stmt.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Pedido! Erro: " + ex.getMessage());
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

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*,pro.id_produto,pro.nome_produto,c.id_contratado,pes.nome_pessoa, r.id_rota, r.nome_rota from pedido p, produto pro,\n"
                + "contratado c, rota r, pessoa pes where p.id_contratado = c.id_contratado and p.id_rota = r.id_rota and \n"
                + "p.id_produto = pro.id_produto and pes.id_pessoa = c.id_pessoa order by p.id_pedido;";// nome da tabela do banco (TUDOMINUSCULO)

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id_pedido"));
                pedido.setDataPedido(rs.getDate("data_pedido"));
                pedido.setLatDestinoPedido(rs.getDouble("lat_destino_pedido"));
                pedido.setLngDestinoPedido(rs.getDouble("lng_destino_pedido"));
                pedido.setStatusPedido(rs.getString("status_pedido"));
                pedido.setProduto(new Produto(rs.getInt("id_produto"), rs.getString("nome_produto")));
                pedido.setContratado(new Contratado(rs.getInt("id_contratado")));
                pedido.setPessoa(new Pessoa(rs.getString("nome_pessoa")));
                pedido.setRota(new Rota(rs.getInt("id_rota"), rs.getString("nome_rota")));
                resultado.add(pedido);
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
        String sql = "Delete from pedido where id_pedido = ?;";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Pedido, Erro: " + ex.getMessage());
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
    

    public Boolean alterarStatusPedido(int idPedido, String statusPedido) {

        PreparedStatement stmt = null;
        String sql = "UPDATE pedido SET status_pedido = ? WHERE id_pedido = ?;";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, statusPedido);
            stmt.setInt(2, idPedido);
            stmt.executeQuery();
            return true;

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar status do pedido! Erro: " + ex.getMessage());
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

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
