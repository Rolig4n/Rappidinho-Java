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

        String sql = "select p.*, a.rg_administrador,c.nome_cidade,e.sigla_estado\"\n"
                + "+ \"from pessoa p \n"
                + "inner join administrador a \n"
                + "on p.id_pessoa = a.id_pessoa \n"
                + "inner join cidade c \n"
                + "on p.id_cidade = c.id_cidade \n"
                + "inner join estado e \n"
                + "on c.id_estado = e.id_estado;";

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

                resultado.add(oAdmin);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Administrador! Erro: " + ex.getMessage());
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

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "delete from administrador where id_pessoa=?; "
                + "commit; "
                + "delete from pessoa where id_pessoa=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.setInt(2, idObject);
            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Problemas ao Excluir Administrador Erro " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar os parametros de conexao " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {
        
        Administrador oAdmin = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select p.*, a.rg_administrador,c.nome_cidade,e.sigla_estado\n" +
"                from pessoa p \n" +
"                inner join administrador a \n" +
"                on p.id_pessoa = a.id_pessoa \n" +
"                inner join cidade c \n" +
"                on p.id_cidade = c.id_cidade \n" +
"                inner join estado e \n" +
"                on c.id_estado = e.id_estado\n" +
"                and p.id_pessoa=?;";

        try {
            stmt = conn.prepareStatement(sql);
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
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    return oAdmin;
    }

    @Override
    public Boolean alterar(Object object) {
        Administrador  oAdmin = (Administrador) object;
        PreparedStatement stmt = null;
        String sql = "update administrador set rg_administrador = ? where id_pessoa= ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oAdmin.getRgAdministrador());
            stmt.setInt(2, oAdmin.getIdPessoa());
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao Alterar Administrador Erro "+ex.getMessage());
            ex.printStackTrace();
            return false;
        }finally{
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexao "+ex.getMessage());ex.printStackTrace();
            }
        }
    }

}
