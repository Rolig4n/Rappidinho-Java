/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.rota;

import DAO.GenericDAO;
import DAO.RotaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contratado;
import model.Rota;

/**
 *
 * @author fbrcmmelo
 */
@WebServlet(name = "CadastrarRota", urlPatterns = {"/CadastrarRota"})
public class CadastrarRota extends HttpServlet {

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
        
        Rota oRota = new Rota();

        oRota.setNomeRota(request.getParameter("nomerota"));
        oRota.setLatSaidaRota(Double.parseDouble(request.getParameter("latsaidarota")));
        oRota.setLngSaidaRota(Double.parseDouble(request.getParameter("lngsaidarota")));
        oRota.setLatChegadaRota(Double.parseDouble(request.getParameter("latchegadarota")));
        oRota.setLngChegadaRota(Double.parseDouble(request.getParameter("lngchegadarota")));
        oRota.setStatusRota("A");
        oRota.setContratado(new Contratado(Integer.parseInt(request.getParameter("idpessoa"))));

        try {
            GenericDAO dao = new RotaDAO();
  
            if(request.getParameter("idrota").equals("")) {
                if (dao.cadastrar(oRota)) {
                    mensagem = "Rota " + oRota.getNomeRota()+ ", cadastrado com Sucesso!";
                } else {
                    mensagem = "Erro ao Cadastrar seus dados, tente novamente!";
                }
            } else {
                oRota.setIdRota(Integer.parseInt(request.getParameter("idrota")));
                if (dao.alterar(oRota)) {
                    mensagem = "Rota " + oRota.getNomeRota()+ ", alterado os dados com Sucesso!";
                } else {
                    mensagem = "Erro ao alterar seus dados, tente novamente!";
                }
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarRota").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas na servlet ao Cadastrar Rota "+ex.getMessage());
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
