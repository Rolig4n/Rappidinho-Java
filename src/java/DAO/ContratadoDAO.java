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
        String sql = "insert into contratado (cnh_contratado, id_pessoa) values (?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oContratado.getCnhContratado());
            try {
                stmt.setInt(2, new PessoaDAO().cadastrar(oContratado));
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

        String sql = "select p.*, con.cnh_contratado,c.nome_cidade,e.sigla_estado\"\n"
                + "+ \"from pessoa p \n"
                + "inner join contratado co \n"
                + "on p.id_pessoa = con.id_pessoa \n"
                + "inner join cidade c \n"
                + "on p.id_cidade = c.id_cidade \n"
                + "inner join estado e \n"
                + "on c.id_estado = e.id_estado;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Contratado oContratado = new Contratado();
                oContratado.setIdPessoa(rs.getInt("id_pessoa"));
                oContratado.setNomePessoa(rs.getString("nome_pessoa"));
                oContratado.setEmailPessoa(rs.getString("email_pessoa"));
                oContratado.setCpfPessoa(rs.getString("cpf_pessoa"));
                oContratado.setCnhContratado(rs.getString("cnh_contratado"));
                oContratado.setEnderecoPessoa(rs.getString("endereco_pessoa"));
                oContratado.setTelefonePessoa(rs.getString("telefone_pessoa"));
                oContratado.setCidade(new Cidade(rs.getString("nome_cidade")));

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
    
    public Contratado mostrarFoto(int idPessoa){
        
        Contratado oContratado   = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.id_pessoa, c.foto_contratado from contratado c "
                + "where c.id_pessoa = ?;";
        
        try{
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPessoa);
            rs = stmt.executeQuery();
            
            if (rs.next()){
                oContratado = new Contratado();
                oContratado.setIdPessoa(rs.getInt("id_pessoa"));
                oContratado.setFotoContratado(rs.getBinaryStream("foto_contratado"));
            }
            
        } catch (SQLException ex){
            System.out.println("Problemas ao listar Foto Contratado! Erro: " + ex.getMessage());
            ex.printStackTrace();            
        } finally {
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex){
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return oContratado;        
    }   

    @Override
    public void excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
