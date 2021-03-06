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
import model.Administrador;
import model.Cidade;
import model.Estado;
import utils.ConnectionFactory;

/**
 *
 * @author fbrcmmelo
 */
public class AdministradorDAO implements GenericDAO {

    private Connection conn;

    public AdministradorDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Banco acessado com Sucesso!");
        } catch (Exception ex) {
            System.out.println("Poblemas ao conectar com o BD");
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Administrador oAdministrador = (Administrador) object;
        PreparedStatement stmt = null;
        String sql = "insert into administrador (rg_administrador, id_pessoa) values (?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oAdministrador.getRgAdministrador());
            try {
                stmt.setInt(2, new PessoaDAO().cadastrar(oAdministrador));
            } catch (Exception ex) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Administrador " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conex??o do usu??rio " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select p.*, a.rg_administrador , c.nome_cidade, e.sigla_estado from pessoa p\n" +
"                inner join administrador a \n" +
"                on p.id_pessoa = a.id_pessoa\n" +
"                inner join cidade c \n" +
"                on p.id_cidade = c.id_cidade \n" +
"                inner join estado e\n" +
"                on c.id_estado = e.id_estado";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Administrador oAdmin = new Administrador();
                oAdmin.setIdPessoa(rs.getInt("id_pessoa"));
                oAdmin.setNomePessoa(rs.getString("nome_pessoa"));
                oAdmin.setEmailPessoa(rs.getString("email_pessoa"));
                oAdmin.setCpfPessoa(rs.getString("cpf_pessoa"));
                oAdmin.setRgAdministrador(rs.getString("rg_administrador"));
                oAdmin.setEnderecoPessoa(rs.getString("endereco_pessoa"));
                oAdmin.setTelefonePessoa(rs.getString("telefone_pessoa"));
                oAdmin.setCidade(new Cidade(rs.getString("nome_cidade")));
                oAdmin.setEstado(new Estado(rs.getString("sigla_estado")));

                resultado.add(oAdmin);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Administrador! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conex??o! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public void excluir(int idObject) {

        PreparedStatement stmt = null;

        String sqlA = "DELETE FROM administrador WHERE id_pessoa = ?;";
        String sqlP = "DELETE FROM pessoa WHERE id_pessoa = ?;";

        try {
            stmt = conn.prepareStatement(sqlA);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement(sqlP);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir administrador! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conex??o! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    @Override
    public Object carregar(int idObject) {

        Administrador oAdmin = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT p.*, a.id_administrador, a.rg_administrador FROM pessoa p, administrador a "
                + "WHERE p.id_pessoa = a.id_pessoa AND p.id_pessoa = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                oAdmin = new Administrador();
                oAdmin.setIdPessoa(rs.getInt("id_pessoa"));
                oAdmin.setNomePessoa(rs.getString("nome_pessoa"));
                oAdmin.setEmailPessoa(rs.getString("email_pessoa"));
                oAdmin.setCpfPessoa(rs.getString("cpf_pessoa"));
                oAdmin.setRgAdministrador(rs.getString("rg_administrador"));
                oAdmin.setEnderecoPessoa(rs.getString("endereco_pessoa"));
                oAdmin.setTelefonePessoa(rs.getString("telefone_pessoa"));
                oAdmin.setCidade(new Cidade(rs.getString("nome_cidade")));
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Administrador! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conex??o! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return oAdmin;
    }

    @Override
    public Boolean alterar(Object object) {
        Administrador oAdmin = (Administrador) object;
        PreparedStatement stmt = null;
        String sql = "update administrador set rg_administrador = ? where id_pessoa= ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oAdmin.getRgAdministrador());
            stmt.setInt(2, oAdmin.getIdPessoa());

            if (new PessoaDAO().alterar(oAdmin)) {
                stmt.executeUpdate();
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Administrador ! Erro: " + ex.getMessage());
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
                System.out.println("Problemas ao fechar conex??o! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

}
