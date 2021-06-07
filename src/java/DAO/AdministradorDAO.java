/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;
import utils.ConnectionFactory;

/**
 *
 * @author fbrcmmelo
 */
public class AdministradorDAO implements GenericDAO{

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
            try{
                stmt.setInt(2, new PessoaDAO().cadastrar(oAdministrador));
            } catch(Exception ex){
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Administrador "+ex.getMessage());
            ex.printStackTrace();
            return false;
        }finally{
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão do usuário "+ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
