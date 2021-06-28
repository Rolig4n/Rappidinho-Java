/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entrega;

import DAO.EntregaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Entrega;
import utils.Conversoes;

/**
 *
 * @author fbrcmmelo
 */
@WebServlet(name = "AlterarStatusEntrega", urlPatterns = {"/AlterarStatusEntrega"})
public class AlterarStatusEntrega extends HttpServlet {

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
        Entrega oEntrega = new Entrega();
        
        try {
            
            EntregaDAO dao = new EntregaDAO();
            if (dao.alterarStatusEntrega(Integer.parseInt(request.getParameter("identrega")), request.getParameter("statusentrega").toUpperCase())){
                mensagem = "Status da Entrega alterado para: " + request.getParameter("statusentrega").toUpperCase();
            } else {
                mensagem = "Problemas ao alterar o Status da Entrega!";
            }
            
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar status da Entrega! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        request.setAttribute("resposta", mensagem);
        request.getRequestDispatcher("ListarEntrega").forward(request, response);
        
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
