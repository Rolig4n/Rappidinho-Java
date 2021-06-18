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
import model.Contratante;
import model.Cidade;
import model.Estado;
import utils.ConnectionFactory;

/**
 *
 * @author fbrcmmelo
 */
public class ContratanteDAO implements GenericDAO {

    private Connection conn;

    public ContratanteDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Banco acessado com Sucesso!");
        } catch (Exception ex) {
            System.out.println("Poblemas ao conectar com o BD");
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Contratante oContratante = (Contratante) object;
        PreparedStatement stmt = null;
        String sql = "insert into contratante (foto_contratante, id_pessoa) values (?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setBinaryStream(1, oContratante.getFotoContratante(), oContratante.getFileInt());
            try {
                stmt.setInt(2, new PessoaDAO().cadastrar(oContratante));
            } catch (Exception ex) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Contratante " + ex.getMessage());
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

        String sql = "select p.*, con.foto_contratante, c.nome_cidade, e.sigla_estado from pessoa p\n" +
"                inner join contratante con \n" +
"                on p.id_pessoa = con.id_pessoa\n" +
"                inner join cidade c \n" +
"                on p.id_cidade = c.id_cidade \n" +
"                inner join estado e\n" +
"                on c.id_estado = e.id_estado";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Contratante oContratante = new Contratante();
                oContratante.setIdPessoa(rs.getInt("id_pessoa"));
                oContratante.setNomePessoa(rs.getString("nome_pessoa"));
                oContratante.setEmailPessoa(rs.getString("email_pessoa"));
                oContratante.setCpfPessoa(rs.getString("cpf_pessoa"));
                oContratante.setEnderecoPessoa(rs.getString("endereco_pessoa"));
                oContratante.setTelefonePessoa(rs.getString("telefone_pessoa"));
                oContratante.setCidade(new Cidade(rs.getString("nome_cidade")));
                oContratante.setEstado(new Estado(rs.getString("sigla_estado")));

                resultado.add(oContratante);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Contratante! Erro: " + ex.getMessage());
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

    public Contratante mostrarFoto(int idPessoa) {

        Contratante oContratante = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.id_pessoa, c.foto_contratante from contratante c "
                + "where c.id_pessoa = ?;";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPessoa);
            rs = stmt.executeQuery();

            if (rs.next()) {
                oContratante = new Contratante();
                oContratante.setIdPessoa(rs.getInt("id_pessoa"));
                oContratante.setFotoContratante(rs.getBinaryStream("foto_contratante"));
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Foto Contratante! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return oContratante;
    }

    @Override
    public void excluir(int idObject) {

        PreparedStatement stmt = null;

        String sqlA = "DELETE FROM contratante WHERE id_pessoa = ?;";
        String sqlP = "DELETE FROM pessoa WHERE id_pessoa = ?;";

        try {
            stmt = conn.prepareStatement(sqlA);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();

            stmt = conn.prepareStatement(sqlP);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir contratante! Erro: " + ex.getMessage());
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
        Contratante oContratante = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, c.id_contratante, c.foto_contratante from pessoa p, contratante c "
                + "where p.id_pessoa = c.id_pessoa and p.id_pessoa = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                oContratante = new Contratante();
                oContratante.setFotoContratante(rs.getBinaryStream("foto_contratante"));
                oContratante.setIdPessoa(rs.getInt("id_pessoa"));
                oContratante.setNomePessoa(rs.getString("nome_pessoa"));
                oContratante.setEmailPessoa(rs.getString("email_pessoa"));
                oContratante.setCpfPessoa(rs.getString("cpf_pessoa"));
                oContratante.setEnderecoPessoa(rs.getString("endereco_pessoa"));
                oContratante.setTelefonePessoa(rs.getString("telefone_pessoa"));
                oContratante.setCidade(new Cidade(rs.getString("nome_cidade")));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao Carregar Contratante ! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return oContratante;
    }

    @Override
    public Boolean alterar(Object object) {
        Contratante oContratante = (Contratante) object;
        PreparedStatement stmt = null;
        String sql = "update contratante set foto_contratante = ? where id_pessoa= ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setBinaryStream(1, oContratante.getFotoContratante(), oContratante.getFileInt());
            stmt.setInt(2, oContratante.getIdPessoa());

            if (new PessoaDAO().alterar(oContratante)) {
                stmt.executeUpdate();
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Contratante ! Erro: " + ex.getMessage());
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
