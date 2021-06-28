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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contratado;
import model.Cidade;
import model.Estado;
import utils.ConnectionFactory;

/**
 *
 * @author fbrcmmelo
 */
public class ContratadoDAO implements GenericDAO {

    private Connection conn;

    public ContratadoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Banco acessado com Sucesso!");
        } catch (Exception ex) {
            System.out.println("Poblemas ao conectar com o BD");
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Contratado oContratado = (Contratado) object;
        PreparedStatement stmt = null;
        String sql = "insert into contratado (foto_contratado, cnh_contratado, id_pessoa) values (?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setBinaryStream(1, oContratado.getFotoContratado(), oContratado.getFileInt());
            stmt.setString(2, oContratado.getCnhContratado());
            try {
                stmt.setInt(3, new PessoaDAO().cadastrar(oContratado));
            } catch (Exception ex) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Contratado " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão do usuário " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select p.*, con.id_contratado, con.foto_contratado, con.cnh_contratado, c.nome_cidade, e.sigla_estado from pessoa p\n" +
"                inner join contratado con \n" +
"                on p.id_pessoa = con.id_pessoa\n" +
"                inner join cidade c \n" +
"                on p.id_cidade = c.id_cidade \n" +
"                inner join estado e\n" +
"                on c.id_estado = e.id_estado";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Contratado oContratado = new Contratado();
                oContratado.setIdPessoa(rs.getInt("id_pessoa"));
                oContratado.setIdContratado(rs.getInt("id_contratado"));
                oContratado.setNomePessoa(rs.getString("nome_pessoa"));
                oContratado.setEmailPessoa(rs.getString("email_pessoa"));
                oContratado.setCpfPessoa(rs.getString("cpf_pessoa"));
                oContratado.setCnhContratado(rs.getString("cnh_contratado"));
                oContratado.setEnderecoPessoa(rs.getString("endereco_pessoa"));
                oContratado.setTelefonePessoa(rs.getString("telefone_pessoa"));
                oContratado.setCidade(new Cidade(rs.getString("nome_cidade")));
                oContratado.setEstado(new Estado(rs.getString("sigla_estado")));

                resultado.add(oContratado);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Contratado! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    public Contratado mostrarFoto(int idPessoa) {

        Contratado oContratado = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.id_pessoa, c.foto_contratado from contratado c "
                + "where c.id_pessoa = ?;";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPessoa);
            rs = stmt.executeQuery();

            if (rs.next()) {
                oContratado = new Contratado();
                oContratado.setIdPessoa(rs.getInt("id_pessoa"));
                oContratado.setFotoContratado(rs.getBinaryStream("foto_contratado"));
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Foto Contratado! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return oContratado;
    }

    @Override
    public void excluir(int idObject) {
        
        PreparedStatement stmt = null;

        String sqlA = "DELETE FROM contratado WHERE id_pessoa = ?;";
        String sqlP = "DELETE FROM pessoa WHERE id_pessoa = ?;";

        try {
            stmt = conn.prepareStatement(sqlA);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement(sqlP);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir contratado! Erro: " + ex.getMessage());
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
        Contratado oContratado = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, c.id_contratado, c.foto_contratado, c.cnh_contratado from pessoa p, contratado c "
                + "where p.id_pessoa = c.id_pessoa and p.id_pessoa = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                oContratado = new Contratado();
                oContratado.setFotoContratado(rs.getBinaryStream("foto_contratado"));
                oContratado.setIdPessoa(rs.getInt("id_pessoa"));
                oContratado.setNomePessoa(rs.getString("nome_pessoa"));
                oContratado.setEmailPessoa(rs.getString("email_pessoa"));
                oContratado.setCpfPessoa(rs.getString("cpf_pessoa"));
                oContratado.setCnhContratado(rs.getString("cnh_contratado"));
                oContratado.setEnderecoPessoa(rs.getString("endereco_pessoa"));
                oContratado.setTelefonePessoa(rs.getString("telefone_pessoa"));
                oContratado.setCidade(new Cidade(rs.getString("nome_cidade")));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao Carregar Contratado ! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return oContratado;
    }

    @Override
    public Boolean alterar(Object object) {
        Contratado oContratado = (Contratado) object;
        PreparedStatement stmt = null;
        String sql = "update contratado set foto_contratado = ?, cnh_contratado = ? where id_pessoa= ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setBinaryStream(1, oContratado.getFotoContratado(), oContratado.getFileInt());
            stmt.setString(2, oContratado.getCnhContratado());
            stmt.setInt(3, oContratado.getIdPessoa());

            if (new PessoaDAO().alterar(oContratado)) {
                stmt.executeUpdate();
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Contratado ! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } catch (Exception ex) {
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

}
