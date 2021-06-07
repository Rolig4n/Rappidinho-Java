/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cidade;
import model.Estado;
import utils.ConnectionFactory;

/**
 *
 * @author fbrcmmelo
 */
public class CidadeDAO implements GenericDAO {
    private Connection conn;

    public CidadeDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Banco acessado com Sucesso!");
        } catch (Exception ex) {
            System.out.println("Poblemas ao conectar com o BD");
        }
    }
    @Override
     public Boolean cadastrar(Object objeto) {
        Cidade oCidade = (Cidade) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into cidade (nome_cidade,id_estado) values (?,?)";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oCidade.getNomeCidade());
            stmt.setInt(2, oCidade.getEstado().getIdEstado());
            
            stmt.execute();
            return true;
        }
        catch(Exception ex){
            System.out.println("Problema ao cadastrar Cidade:Erro:" +ex.getMessage());
            return false;
        }
        finally{ //fechar o BD não importa o que aconteça
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }
            catch(Exception ex){
                System.out.println("Problema ao fechar os parametros de conecao! Erro:" +ex.getMessage());
            }
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Cidade oCidade = (Cidade) objeto;
        PreparedStatement stmt = null;
        String sql = "update cidade set nome_cidade=? where id_estado=? and id_cidade=?";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oCidade.getNomeCidade());
            stmt.setInt(2, oCidade.getEstado().getIdEstado());
            stmt.setInt(3, oCidade.getIdCidade());
            
            stmt.execute();
            return true;
        }
        catch(Exception ex){
            System.out.println("Problema ao alterar Cidade:Erro:" +ex.getMessage());
            return false;
        }
        finally{ //fechar o BD não importa o que aconteça
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }
            catch(Exception ex){
                System.out.println("Problema ao fechar os parametros de conecao! Erro:" +ex.getMessage());
            }
        }
    }

    @Override
    public void excluir(int idObjeto) {
       
    }

    @Override
    public Object carregar(int idObject){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cidade oCidade = null;
        String sql="select c.*, e.nome_estado "
                + "from cidade c, estado e"
                + " where c.id_estado = e.id_estado and "
                + "c.id_cidade = ?";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,idObject);
            rs=stmt.executeQuery();
            while (rs.next()){
                oCidade = new Cidade();
                oCidade.setIdCidade(rs.getInt("id_cidade"));
                oCidade.setNomeCidade(rs.getString("nome_cidade"));
                oCidade.setEstado(new Estado(rs.getInt("id_estado"), rs.getString("nome_estado")));
            }
            return oCidade;
        }catch (Exception ex) {
            System.out.println("Problmas ao carregar Cidade! Erro: " + ex.getMessage());
            return false;
            }
        finally{
            try{
                ConnectionFactory.closeConnection(conn,stmt,rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar parametros de conn! Erro: "+ex.getMessage());
            }
        }
        }
    
    

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.*, e.sigla_estado "
                + "from cidade c, estado e "
                + "WHERE c.id_estado = e.id_estado "
                + "ORDER BY c.nome_cidade;";;// nome da tabela do banco (TUDOMINUSCULO)
        
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Cidade oCidade = new Cidade();
                oCidade.setIdCidade(rs.getInt("id_cidade"));
                oCidade.setNomeCidade(rs.getString("nome_cidade"));
                oCidade.setEstado(new Estado(rs.getString("sigla_estado")));
                
                resultado.add(oCidade);
            }
        }
        catch(Exception ex){
            System.out.println("Problema ao listar Cidade:Erro:" +ex.getMessage());
        }
        finally{ //fechar o BD não importa o que aconteça
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }
            catch(Exception ex){
                System.out.println("Problema ao fechar os parametros de conn! Erro:" +ex.getMessage());
            }
        }
        return resultado;
    }
    
   
 
}
