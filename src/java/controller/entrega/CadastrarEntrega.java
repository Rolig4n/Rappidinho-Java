/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entrega;

import DAO.EntregaDAO;
import DAO.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contratado;
import model.Contratante;
import model.Entrega;
import model.Pedido;
import model.Rota;
import org.apache.commons.fileupload.FileItem;
import utils.Conversoes;

/**
 *
 * @author fbrcmmelo
 */
@WebServlet(name = "CadastrarEntrega", urlPatterns = {"/CadastrarEntrega"})
public class CadastrarEntrega extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        

        String mensagem = null;
        Entrega oEntrega = null;
        oEntrega = new Entrega();
        oEntrega.setDataEntrega(oEntrega.getDataEntrega());
        oEntrega.setStatusEntrega("A");
        oEntrega.setRota(new Rota (Integer.parseInt(request.getParameter("idrota"))));
        oEntrega.setPedido(new Pedido(Integer.parseInt(request.getParameter("idpedido"))));
        oEntrega.setContratado(new Contratado(Integer.parseInt(request.getParameter("idcontratado"))));
        
        try {
            GenericDAO dao = new EntregaDAO();
  
            if(request.getParameter("identrega").equals("")) {
                if (dao.cadastrar(oEntrega)) {
                    mensagem = "Entrega, cadastrada com Sucesso!";
                } else {
                    mensagem = "Erro ao Cadastrar seus dados, tente novamente!";
                }
            } else {
                oEntrega.setIdEntrega(Integer.parseInt(request.getParameter("identrega")));
                if (dao.alterar(oEntrega)) {
                    mensagem = "Entrega , alterada os dados com Sucesso!";
                } else {
                    mensagem = "Erro ao alterar seus dados, tente novamente!";
                }
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarEntrega").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas na servlet ao Cadastrar Entrega "+ex.getMessage());
            ex.printStackTrace();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
